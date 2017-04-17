package org.origami.trading.core.worker.daos.rest.byma;

import org.origami.trading.core.worker.daos.rest.byma.connectors.BymaConnectionManager;
import org.origami.trading.core.worker.marketdata.Quote;
import org.origami.trading.core.worker.marketdata.QuoteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created by dmoreira on 3/25/17.
 */
public class BymaRestDaoImpl implements MarketDao {

    private final Logger logger = LoggerFactory.getLogger(BymaRestDaoImpl.class);

    private BymaConnectionManager connectionManager;
    private RestTemplate restTemplate;
    private Map<QueryType,String> queryPathsByQueryType;
    private Map<Class<?>,QuoteMapper> quoteMappersByClazz;

    public BymaRestDaoImpl(BymaConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        this.restTemplate = connectionManager.getRestTemplate();
    }

    @Override
    public <T> Quote getSingleQuote(String name, Class<T> clazz) {
        return null;
    }

    @Override
    public <T extends Quote> List<T> getQuotes(Class<T> clazz, QueryType queryType) {

        final String queryPath = queryPathsByQueryType.get(queryType);
        if (queryPath == null || queryPath.equals("")) {
            logger.error("[MarketRestDao getQuotes() Error, " +
                    "didn't find a suitable query path for the requested Query Type. " +
                    "Please check that the Query Type is configured and has a Query Path.]");
            return null;
        }

        final QuoteMapper quoteMapper = quoteMappersByClazz.get(clazz);
        if (quoteMapper == null) {
            logger.error("[MarketRestDao getQuotes() Error, " +
                    "didn't find a suitable mapper for the requested class. " +
                    "Please check that the Class is configured and has a Mapper]");
            return null;
        }

        MarketConnection marketConnection = connectionManager.getMarketConnection();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.put("Cookie", marketConnection.getCookies());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(marketConnection.getHost())
                .path(queryPath);

        final HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            logger.info(String.format("[Quotes retrieved for %s]",clazz.getSimpleName()));
            return (List<T>) quoteMapper.unmarshal(response.getBody());
        } else {
            logger.error(String.format("[Error getQuotes(); Something went wrong ... ; " +
                    "Path: %s, Status: %d]",queryPath,response.getStatusCodeValue()));
            return null;
        }

    }

    public void setConnectionManager(BymaConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    public void setQueryPathsByQueryType(Map<QueryType, String> queryPathsByQueryType) {
        this.queryPathsByQueryType = queryPathsByQueryType;
    }

    public void setQuoteMappersByClazz(Map<Class<?>, QuoteMapper> quoteMappersByClazz) {
        this.quoteMappersByClazz = quoteMappersByClazz;
    }
}
