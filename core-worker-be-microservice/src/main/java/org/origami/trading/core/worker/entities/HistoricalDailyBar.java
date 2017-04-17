package org.origami.trading.core.worker.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "historical_daily_bars")
public class HistoricalDailyBar {

    @Id
    private String hiTicker;
    private java.sql.Timestamp hiTimestamp;
    private double hiClose;
    private double hiOpen;
    private double hiLow;
    private double hiHigh;
    private double hiChange;

    public String getHiTicker() {
        return hiTicker;
    }

    public void setHiTicker(String hiTicker) {
        this.hiTicker = hiTicker;
    }

    public java.sql.Timestamp getHiTimestamp() {
        return hiTimestamp;
    }

    public void setHiTimestamp(java.sql.Timestamp hiTimestamp) {
        this.hiTimestamp = hiTimestamp;
    }

    public double getHiClose() {
        return hiClose;
    }

    public void setHiClose(double hiClose) {
        this.hiClose = hiClose;
    }

    public double getHiOpen() {
        return hiOpen;
    }

    public void setHiOpen(double hiOpen) {
        this.hiOpen = hiOpen;
    }

    public double getHiLow() {
        return hiLow;
    }

    public void setHiLow(double hiLow) {
        this.hiLow = hiLow;
    }

    public double getHiHigh() {
        return hiHigh;
    }

    public void setHiHigh(double hiHigh) {
        this.hiHigh = hiHigh;
    }


    public double getHiChange() {
        return hiChange;
    }

    public void setHiChange(double hiChange) {
        this.hiChange = hiChange;
    }

}
