package org.origami.trading.core.worker.processors;

import org.origami.trading.core.worker.marketdata.stocks.models.BymaStock;

import java.util.List;

/**
 * Created by dmoreira on 4/16/17.
 */
public class BymaDailyBarsProcessor {


    public void processCurrentBars(List<BymaStock> stocks) {
        for (BymaStock stock : stocks) {
            processCurrentBars(stock);
        }
    }

    public void processCurrentBars(BymaStock stock) {

    }

}
