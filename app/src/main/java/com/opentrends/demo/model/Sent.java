/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: Sent.java
*
*
* Version Number: 0.0.0.1
*
* Created Date: 17 Mar 2016
*
*/
package com.opentrends.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sent {

    @SerializedName("results")
    @Expose
    private String results;

    /**
     * @return The results
     */
    public String getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(String results) {
        this.results = results;
    }

}
