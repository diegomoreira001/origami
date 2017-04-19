package org.origami.trading.core.worker.persistences.cache;

import org.origami.trading.core.worker.entities.HistoricalDailyBar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmoreira on 4/16/17.
 */
public class InMemoryBarsCache {

    private Map<String, HistoricalDailyBar> barsByTicker = new HashMap();

    public HistoricalDailyBar findBar(String ticker) {
        return barsByTicker.get(ticker);
    }

    public HistoricalDailyBar put(HistoricalDailyBar bar) {
        barsByTicker.put(bar.getHiTicker(), bar);
        return bar;
    }

}
