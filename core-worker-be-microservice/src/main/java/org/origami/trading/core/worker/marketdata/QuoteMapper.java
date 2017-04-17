package org.origami.trading.core.worker.marketdata;

import java.util.List;

/**
 * Created by diego.moreira on 3/29/2017.
 */
public interface QuoteMapper {
    
    List<? extends Quote> unmarshal(String html);
}
