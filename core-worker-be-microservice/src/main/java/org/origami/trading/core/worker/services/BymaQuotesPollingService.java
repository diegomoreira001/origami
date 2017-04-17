package org.origami.trading.core.worker.services;

import org.origami.trading.core.worker.daos.rest.byma.BymaRestDaoImpl;
import org.origami.trading.core.worker.daos.rest.byma.QueryType;
import org.origami.trading.core.worker.marketdata.stocks.models.BymaStock;
import org.origami.trading.core.worker.processors.BymaDailyBarsProcessor;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * Created by dmoreira on 3/27/17.
 */
//@Service
public class BymaQuotesPollingService {

    private BymaRestDaoImpl bymaRestDao;
    private BymaDailyBarsProcessor bymaDailyBarsProcessor;

    @Scheduled(fixedDelay = 5000L)
    public void pollBlueChipStockQuotes() {

        List<BymaStock> bymaBlueChipStocks = bymaRestDao.getQuotes(BymaStock.class, QueryType.BLUE_CHIP_STOCKS);
        bymaDailyBarsProcessor.processCurrentBars(bymaBlueChipStocks);
        //Retrieve stocks from Bolsar
        //


    }


}
