package org.origami.trading.core.worker.daos.rest.byma;

import org.origami.trading.core.worker.marketdata.Quote;

import java.util.List;

/**
 * Created by dmoreira on 3/25/17.
 */
public interface MarketDao {

    <T> Quote getSingleQuote(String name, Class<T> clazz);

    <T extends Quote> List<T> getQuotes(Class<T> clazz, QueryType queryType);
    //<T> List<Quote<T>> getQuotes(List<String> names);

}
