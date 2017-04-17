package org.origami.trading.tv.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by dmoreira on 4/15/17.
 */
public class SymbolInformation {

    private String name; // No utilizar
    private String ticker; // Este es el bueno
    private String description; // Opcional
    private String session; //Format: HH24MM-HH24MM
    private String exchange; // BA
    private String timezone; //Format: America/Argentina/Buenos_Aires
    private int minmov; // 1 por ahora para cambios de 0.01
    private int minmove2; // 0
    private int pricescale; // No tengo idea
    private boolean fractional; // False: por ahora no, quizas en el futuro.
    @JsonProperty("supported_resolutions")
    private String[] supportedResolutions; //["1", "10","D", "1W", "1M"]
    private String type; // stock ... no voy a hacer bonos por ahora
    @JsonProperty("has_intraday") // True: intervalos de un minuto por ahora
    private boolean hasIntraday;
    @JsonProperty("intraday_multipliers")
    private String intradayMultipliers; // [1] reconstruccion dinamica de barras de 5 y 10 minutos.
    @JsonProperty("has_second")
    private boolean hasSeconds; // False: Por ahora no
    @JsonProperty("has_daily")
    private boolean hasDaily; // True
    @JsonProperty("has_monthly_and_weekly")
    private boolean hasMonthlyAndWeekly; //False: Reconstruccion dinamica basada en datos diarios.
    @JsonProperty("has_no_volume")
    private boolean hasNoVolume; // True: deberiamos poder entregarlo.
    @JsonProperty("data_status")
    private String dataStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getMinmov() {
        return minmov;
    }

    public void setMinmov(int minmov) {
        this.minmov = minmov;
    }

    public int getMinmove2() {
        return minmove2;
    }

    public void setMinmove2(int minmove2) {
        this.minmove2 = minmove2;
    }

    public int getPricescale() {
        return pricescale;
    }

    public void setPricescale(int pricescale) {
        this.pricescale = pricescale;
    }

    public boolean isFractional() {
        return fractional;
    }

    public void setFractional(boolean fractional) {
        this.fractional = fractional;
    }

    public String[] getSupportedResolutions() {
        return supportedResolutions;
    }

    public void setSupportedResolutions(String[] supportedResolutions) {
        this.supportedResolutions = supportedResolutions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasIntraday() {
        return hasIntraday;
    }

    public void setHasIntraday(boolean hasIntraday) {
        this.hasIntraday = hasIntraday;
    }

    public String getIntradayMultipliers() {
        return intradayMultipliers;
    }

    public void setIntradayMultipliers(String intradayMultipliers) {
        this.intradayMultipliers = intradayMultipliers;
    }

    public boolean isHasSeconds() {
        return hasSeconds;
    }

    public void setHasSeconds(boolean hasSeconds) {
        this.hasSeconds = hasSeconds;
    }

    public boolean isHasDaily() {
        return hasDaily;
    }

    public void setHasDaily(boolean hasDaily) {
        this.hasDaily = hasDaily;
    }

    public boolean isHasMonthlyAndWeekly() {
        return hasMonthlyAndWeekly;
    }

    public void setHasMonthlyAndWeekly(boolean hasMonthlyAndWeekly) {
        this.hasMonthlyAndWeekly = hasMonthlyAndWeekly;
    }

    public boolean isHasNoVolume() {
        return hasNoVolume;
    }

    public void setHasNoVolume(boolean hasNoVolume) {
        this.hasNoVolume = hasNoVolume;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}
