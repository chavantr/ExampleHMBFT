package com.exam.hmbft;

import android.os.AsyncTask;

import org.json.JSONObject;

public class FoodOrder extends AsyncTask<JSONObject,Void,String> {

    private HttpConnectionUtil httpConnectionUtil = new HttpConnectionUtil();

    @Override
    protected String doInBackground(JSONObject... params) {



        return httpConnectionUtil.requestPost(Constants.URL + Constants.FOOD_ORDER,params[0]);
    }
}
