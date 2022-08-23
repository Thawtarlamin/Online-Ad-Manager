package com.thukuma.onlinead;

import android.content.Context;

public class Ads_Manager {

    private Context context;
    private GetOnlineData data;
    private Prefrence prefrence;

    public Ads_Manager(Context context, GetOnlineData data, Prefrence prefrence) {
        this.context = context;
        this.data = data;
        this.prefrence = prefrence;

    }
    public interface onComplete{
        void onComplete(Prefrence prefrence);
    }
    public interface onError{
        void onError(Exception e);
    }
}
