/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: GsonHelper.java
*
*
* Version Number: 0.0.0.1
*
* Created Date: 15 Mar 2016
*
*/
package com.opentrends.demo.util;

import com.google.gson.Gson;
import com.opentrends.demo.model.ResponseModel;

public class GsonHelper {

    /**
     * Parse data using GSON Library
     * @param response
     * @return
     */
    public ResponseModel parseJson(String response) {
        Gson gson = new Gson();
        return gson.fromJson(response, ResponseModel.class);
    }
}
