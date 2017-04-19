package org.origami.trading.core.worker.processors;

import org.origami.trading.core.worker.entities.HistoricalDailyBar;
import org.origami.trading.core.worker.marketdata.stocks.models.BymaStock;
import org.origami.trading.core.worker.persistences.PersistenceRoutingManager;

import java.util.List;

/**
 * Created by dmoreira on 4/16/17.
 */
public class BymaDailyBarsProcessor {

    PersistenceRoutingManager persistenceRoutingManager;

    public void processCurrentBars(List<BymaStock> stocks) {
        for (BymaStock stock : stocks) {
            processCurrentBars(stock);
        }
    }

    public void processCurrentBars(BymaStock stock) {

        //Find if there is a bar present.
        HistoricalDailyBar bar = persistenceRoutingManager.findBar(stock.getTicker());



    }

    public PersistenceRoutingManager getPersistenceRoutingManager() {
        return persistenceRoutingManager;
    }

    public void setPersistenceRoutingManager(PersistenceRoutingManager persistenceRoutingManager) {
        this.persistenceRoutingManager = persistenceRoutingManager;
    }
}
