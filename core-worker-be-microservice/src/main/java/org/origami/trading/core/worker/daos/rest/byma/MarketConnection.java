package org.origami.trading.core.worker.daos.rest.byma;

import java.util.Date;
import java.util.List;

/**
 * Created by dmoreira on 3/25/17.
 */
public interface MarketConnection {

    String getHost();
    String getUser();
    String getToken();
    Date getStartTime();
    boolean isAlive();
    List<String> getCookies();

}
