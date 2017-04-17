package org.origami.trading.core.worker.daos.rest.byma.connectors;

import org.origami.trading.core.worker.daos.rest.byma.MarketConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dmoreira on 3/25/17.
 */
public class BymaMarketConnection implements MarketConnection {

    final Logger logger = LoggerFactory.getLogger(BymaMarketConnection.class);

    private String host;
    private String token;
    private String user;
    private List<String> cookies;
    private Date startTime;
    private String state;
    private long maxAge = 0L;

    public BymaMarketConnection(String host, String token, String user, List<String> cookies, long maxAge) {
        this.host = host;
        this.token = token;
        this.user = user;
        this.cookies = cookies;
        this.maxAge = maxAge;

        if (cookies != null && !cookies.isEmpty()) {
            this.state = "ACTIVE";
            this.startTime = Calendar.getInstance().getTime();
        }

        logger.debug(String.format("BymaMarketConnection Created - State: %s, User: %s, Cookie: %s, Start-Time: %s",
                this.state, this.user == null ? "null" : this.user, this.cookies.toString(), this.startTime.toString()));
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    public void setState(String state) { this.state = state; }

    public List<String> getCookies() {
        return cookies;
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    @Override
    public boolean isAlive() {
        long upTime = Calendar.getInstance().getTimeInMillis() - this.startTime.getTime() ;
        return (this.state.equals("ACTIVE") && upTime < maxAge);
    }

    @Override
    public String getHost() {
        return host;
    }
}
