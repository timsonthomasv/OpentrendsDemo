/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: Result.java
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

public class Result {

    @SerializedName("entity")
    @Expose
    private Entity entity;
    @SerializedName("seed")
    @Expose
    private String seed;

    /**
     * @return The entity
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * @param entity The entity
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    /**
     * @return The seed
     */
    public String getSeed() {
        return seed;
    }

    /**
     * @param seed The seed
     */
    public void setSeed(String seed) {
        this.seed = seed;
    }

}
