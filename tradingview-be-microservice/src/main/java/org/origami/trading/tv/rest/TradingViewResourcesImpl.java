package org.origami.trading.tv.rest;

import org.origami.trading.tv.rest.models.ApiConfiguration;
import org.origami.trading.tv.rest.models.Bar;
import org.origami.trading.tv.rest.models.SymbolInformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dmoreira on 4/15/17.
 */
@Controller
public class TradingViewResourcesImpl implements TradingViewResources {
    @Override
    public ApiConfiguration getApiConfiguration() {
        return null;
    }

    @Override
    public SymbolInformation getSymbolInformation(@RequestParam String symbol) {
        return null;
    }

    @Override
    public Bar getSymbolInformation(@RequestParam String symbol, @RequestParam String resolution, @RequestParam String from, @RequestParam String to) {
        return null;
    }
}
