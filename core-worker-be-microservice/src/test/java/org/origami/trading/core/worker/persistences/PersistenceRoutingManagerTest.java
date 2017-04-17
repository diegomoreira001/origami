package org.origami.trading.core.worker.persistences;

import org.junit.Before;
import org.junit.Test;
import org.origami.trading.core.worker.daos.repositories.HistoricalDailyBarsRepository;
import org.origami.trading.core.worker.entities.HistoricalDailyBar;
import org.origami.trading.core.worker.persistences.cache.InMemoryBarsCache;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by dmoreira on 4/16/17.
 */
public class PersistenceRoutingManagerTest {

    private PersistenceRoutingManager persistenceRoutingManager;
    private InMemoryBarsCache inMemoryBarsCache;
    private HistoricalDailyBarsRepository historicalDailyBarsRepository;

    @Before
    public void setUp() {
        persistenceRoutingManager = new PersistenceRoutingManager();
        inMemoryBarsCache = mock(InMemoryBarsCache.class);
        historicalDailyBarsRepository = mock(HistoricalDailyBarsRepository.class);

        persistenceRoutingManager.setInMemoryBarsCache(inMemoryBarsCache);
        persistenceRoutingManager.setHistoricalDailyBarsRepository(historicalDailyBarsRepository);
    }


    @Test
    public void findBarFromCacheHappyTest() throws Exception {
        String ticker = "AGRO";
        HistoricalDailyBar mockedBar = new HistoricalDailyBar();
        mockedBar.setHiTicker(ticker);
        mockedBar.setHiOpen(23.0);
        mockedBar.setHiClose(25.0);

        when(inMemoryBarsCache.findBar(ticker)).thenReturn(mockedBar);
        HistoricalDailyBar bar = persistenceRoutingManager.findBar(ticker);
        assertNotNull(bar);
        assertEquals(ticker, bar.getHiTicker());

        verify(historicalDailyBarsRepository, never()).findOne(ticker);

    }

    @Test
    public void findBarFromDbHappyTest() throws Exception {
        String ticker = "AGRO";
        HistoricalDailyBar mockedBar = new HistoricalDailyBar();
        mockedBar.setHiTicker(ticker);
        mockedBar.setHiOpen(23.0);
        mockedBar.setHiClose(25.0);

        when(inMemoryBarsCache.findBar(ticker)).thenReturn(null);
        when(historicalDailyBarsRepository.findOne(ticker)).thenReturn(mockedBar);
        HistoricalDailyBar bar = persistenceRoutingManager.findBar(ticker);
        assertNotNull(bar);
        assertEquals(ticker, bar.getHiTicker());

        verify(inMemoryBarsCache).findBar(ticker);
        verify(historicalDailyBarsRepository, times(1)).findOne(ticker);

    }

}