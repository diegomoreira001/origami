package org.origami.trading.core.worker.daos.rest.byma;

/**
 * Created by diego.moreira on 3/31/2017.
 */
public enum QueryType {
    GENERAL_STOCKS("general_stocks"),
    BLUE_CHIP_STOCKS("blue_chip_stocks"),
    PYME_STOCKS("pyme_stocks"),
    BOND("bond"),
    STOCK_OPTIONS("stock_options");

    private final String value;

    QueryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
