package org.origami.trading.tv.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by dmoreira on 4/15/17.
 */
public class Bar {

    @JsonProperty("s")
    private String status;
    @JsonProperty("errmsg")
    private String errorMessage;
    @JsonProperty("t")
    private String timestamp;
    @JsonProperty("c")
    private int closePrice;
    @JsonProperty("o")
    private int openPrice;
    @JsonProperty("h")
    private int highPrice;
    @JsonProperty("l")
    private int lowPrice;
    @JsonProperty("v")
    private int volume;
    @JsonProperty("nextTime")
    private String nextTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(int closePrice) {
        this.closePrice = closePrice;
    }

    public int getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(int openPrice) {
        this.openPrice = openPrice;
    }

    public int getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }

    public int getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }
}
