package org.origami.trading.tv.rest;

import org.origami.trading.tv.rest.models.ApiConfiguration;
import org.origami.trading.tv.rest.models.Bar;
import org.origami.trading.tv.rest.models.SymbolInformation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dmoreira on 4/15/17.
 */
@RequestMapping("/tv")
public interface TradingViewResources {

    @RequestMapping(path = "/config", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ApiConfiguration getApiConfiguration();

    @RequestMapping(path = "/symbols", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    SymbolInformation getSymbolInformation(@RequestParam String symbol);

    @RequestMapping(path = "/history", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Bar getSymbolInformation(@RequestParam String symbol,
                             @RequestParam String resolution,
                             @RequestParam String from,
                             @RequestParam String to);

}
