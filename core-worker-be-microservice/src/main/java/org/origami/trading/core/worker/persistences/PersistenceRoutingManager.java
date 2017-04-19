package org.origami.trading.core.worker.persistences;

import org.origami.trading.core.worker.daos.repositories.HistoricalDailyBarsRepository;
import org.origami.trading.core.worker.entities.HistoricalDailyBar;
import org.origami.trading.core.worker.persistences.cache.InMemoryBarsCache;


/**
 * @author dmoreira
 *
 * Class that will handle routing of queries to either Cache or Database
 *
 */
public class PersistenceRoutingManager {

    private InMemoryBarsCache inMemoryBarsCache;
    private HistoricalDailyBarsRepository historicalDailyBarsRepository;

    /**
     *
     * @param ticker
     * @return
     */
    public HistoricalDailyBar findBar(String ticker) {
        HistoricalDailyBar bar = null;
        // Level 1 Search: In-Memory
        bar = inMemoryBarsCache.findBar(ticker);
        if (bar == null) {
            //Level 2 Search: Persistence
            bar = historicalDailyBarsRepository.findOne(ticker);
            //When a Bar is found in the DB, cache the result
            if (bar != null) {
                inMemoryBarsCache.put(bar);
            }
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
