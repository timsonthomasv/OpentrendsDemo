/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: Entity.java
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

public class Entity {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("descritpion")
    @Expose
    private String descritpion;

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return The number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number The number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return The picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture The picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return The descritpion
     */
    public String getDescritpion() {
        return descritpion;
    }

    /**
     * @param descritpion The descritpion
     */
    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

}
