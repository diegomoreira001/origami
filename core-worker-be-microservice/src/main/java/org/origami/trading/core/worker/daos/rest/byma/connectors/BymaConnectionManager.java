package org.origami.trading.core.worker.daos.rest.byma.connectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by dmoreira on 3/25/17.
 */
public class BymaConnectionManager {

    private final Logger logger = LoggerFactory.getLogger(BymaConnectionManager.class);

    // Login parameters.
    private String host;
    private String loginPath;
    private String token;

    // Maximum connection Age.
    private long maxAge;

    // Spring's Rest Template.
    private RestTemplate restTemplate;

    // Connection Object.
    private BymaMarketConnection marketConnection;

    // Default: 5s.
    private long retryInterval = 5000L;
    private int maxAttempts = 3;

    public synchronized BymaMarketConnection getMarketConnection() {

        if (this.marketConnection == null || !this.marketConnection.isAlive()) {
            establishConnection();
        }

        return marketConnection;
    }

    /**
     * Establishes a connection against the third-party quotes provider.
     * It logins using a token and gets back a session cookie.
     *
     * The session expires after 30 minutes.
     *
     * This method is executed at a fixed rate to refresh the session.
     *
     * @return BymaMarketConnection
     */
    public BymaMarketConnection establishConnection() {

        this.marketConnection = null;
        this.marketConnection = this.connect();

        if (this.marketConnection == null || !this.marketConnection.isAlive()) {
            handleReconnect();
        }

        return this.marketConnection;
    }

    private BymaMarketConnection connect() {

        BymaMarketConnection connection = null;

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.host)
                .path(this.loginPath)
                .queryParam("token",this.token);

        final HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<String> response = this.restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            List<String> cookies = response.getHeaders().get("Set-Cookie");
            connection = new BymaMarketConnection(this.host, this.token, null, cookies, maxAge);
            logger.info(String.format("[Connected to Merval - Start Time: %s]", connection.getStartTime().toString()));
        } else {
            logger.info(String.format("[Unable to connect to Merval - Status Code: %d]", response.getStatusCodeValue()));
        }

        return connection;
    }

    private void handleReconnect() {
        try {
            int attempts = 1;
            while ((marketConnection == null || !marketConnection.isAlive()) &&
                    attempts > maxAttempts) {
                Thread.sleep(retryInterval);
                logger.info(String.format("[Attempting to reconnect ...]"));
                this.marketConnection = connect();
                attempts++;
            }
            if (attempts > maxAttempts) {
                logger.info(String.format("[Attempted to reconnect %d times... Giving up.]",attempts));
                throw new RuntimeException(String.format("[Attempted to reconnect %d times... Giving up.]",attempts));
            }
        } catch (InterruptedException iE) {
            logger.error(iE.getMessage());
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLoginPath() {
        return loginPath;
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public long getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(long retryInterval) {
        this.retryInterval = retryInterval;
    }

    public long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(long maxAge) {
        this.maxAge = maxAge;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }
}
