package org.origami.trading.core.worker.persistences;

import org.origami.trading.core.worker.daos.repositories.HistoricalDailyBarsRepository;
import org.origami.trading.core.worker.entities.HistoricalDailyBar;
import org.origami.trading.core.worker.persistences.cache.InMemoryBarsCache;

/**
 * Created by dmoreira on 4/16/17.
 */
public class PersistenceRoutingManager {

    private InMemoryBarsCache inMemoryBarsCache;
    private HistoricalDailyBarsRepository historicalDailyBarsRepository;

    public HistoricalDailyBar findBar(String ticker) {
        HistoricalDailyBar bar = null;
        // Level 1 Search: In-Memory
        bar = inMemoryBarsCache.findBar(ticker);
        if (bar == null) {
            //Level 2 Search: Persistence
            bar = historicalDailyBarsRepository.findOne(ticker);
        }

        return bar;
    }

    public void setInMemoryBarsCache(InMemoryBarsCache inMemoryBarsCache) {
        this.inMemoryBarsCache = inMemoryBarsCache;
    }

    public void setHistoricalDailyBarsRepository(HistoricalDailyBarsRepository historicalDailyBarsRepository) {
        this.historicalDailyBarsRepository = historicalDailyBarsRepository;
    }
}
