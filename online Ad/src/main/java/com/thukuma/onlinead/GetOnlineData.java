package com.thukuma.onlinead;

import android.content.Context;
import android.preference.Preference;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class GetOnlineData {
    private Context context;
    private String url;
    private Ads_Manager.onComplete complete;
    private Ads_Manager.onError error;

    public GetOnlineData(Context context, String url, Ads_Manager.onComplete complete, Ads_Manager.onError error) {
        this.context = context;
        this.url = url;
        this.complete = complete;
        this.error = error;
        getAds();
    }

    public  void getAds(){
        Prefrence prefrence = new Prefrence(context);
        AndroidNetworking.get(url)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String banner = response.getString("banner");
                            String inter = response.getString("inter");
                            String app_id = response.getString("app_id");
                            prefrence.save_id(app_id, banner, inter);
                            complete.onComplete(prefrence);
                        } catch (JSONException e) {
                            error.onError(e);
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        error.onError(anError);
                    }
                });
    }
}
