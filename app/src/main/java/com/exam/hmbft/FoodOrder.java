package com.exam.hmbft;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

public class FoodOrder extends AsyncTask<JSONArray, Void, String> {


    public void setOnSuccessListener(OnSuccessListener onSuccessListener, JSONArray request) {
        this.onSuccessListener = onSuccessListener;
        super.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, request);
    }

    private OnSuccessListener onSuccessListener;


    private HttpConnectionUtil httpConnectionUtil = new HttpConnectionUtil();

    @Override
    protected String doInBackground(JSONArray... params) {
        return httpConnectionUtil.requestPost(Constants.URL + Constants.FOOD_ORDER, params[0]);
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        onSuccessListener.onSuccess(s);
    }
}
