package com.thukuma.onlinead;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.Preference;

public class Prefrence {
    private Context context;

    public Prefrence(Context context) {
        this.context = context;
    }

    public void save_id(String app_id,String banner,String  inter) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("app_id",app_id);
        editor.putString("banner",banner);
        editor.putString("inter",inter);
        editor.commit();
    }
    public String load_banner(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        return sharedPreferences.getString("banner", context.getString(R.string.banner_ads));
    }
    public String load_inter(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        return sharedPreferences.getString("inter", context.getString(R.string.intertitialAds));
    }
    @SuppressLint("CommitPrefEdits")
    public void removed(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        sharedPreferences.edit().remove("app_id");
        sharedPreferences.edit().remove("banner");
        sharedPreferences.edit().remove("inter");
        sharedPreferences.edit().remove("rewards");
        sharedPreferences.edit().remove("status");
    }
    public void app_id_set(){
        ApplicationInfo ai = null;
        try {
            ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            String myApiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");

            ai.metaData.putString("com.google.android.gms.ads.APPLICATION_ID", load_app_id());//you can replace your key APPLICATION_ID here
            String ApiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String load_app_id(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        return sharedPreferences.getString("app_id", context.getString(R.string.app_id));
    }
}
