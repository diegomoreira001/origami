package org.origami.trading.tv.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by dmoreira on 4/15/17.
 */
public class ApiConfiguration {

    @JsonProperty("supports_search")
    private String supportsSearch;
    @JsonProperty("supports_group_request")
    private String supportsGroupRequest;
    @JsonProperty("supported_resolutions")
    private String supportedResolutions;
    @JsonProperty("supports_marks")
    private String supportsMarks;
    @JsonProperty("supports_time")
    private String supportsTime;

    public String getSupportsSearch() {
        return supportsSearch;
    }

    public void setSupportsSearch(String supportsSearch) {
        this.supportsSearch = supportsSearch;
    }

    public String getSupportsGroupRequest() {
        return supportsGroupRequest;
    }

    public void setSupportsGroupRequest(String supportsGroupRequest) {
        this.supportsGroupRequest = supportsGroupRequest;
    }

    public String getSupportedResolutions() {
        return supportedResolutions;
    }

    public void setSupportedResolutions(String supportedResolutions) {
        this.supportedResolutions = supportedResolutions;
    }

    public String getSupportsMarks() {
        return supportsMarks;
    }

    public void setSupportsMarks(String supportsMarks) {
        this.supportsMarks = supportsMarks;
    }

    public String getSupportsTime() {
        return supportsTime;
    }

    public void setSupportsTime(String supportsTime) {
        this.supportsTime = supportsTime;
    }
}
