package com.thukuma.onlineadmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.thukuma.onlinead.Ads_Manager;
import com.thukuma.onlinead.GetOnlineData;
import com.thukuma.onlinead.Prefrence;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetOnlineData(MainActivity.this, "https://raw.githubusercontent.com/Thawtarlamin/test-json/main/ad-manager.json",new Ads_Manager.onComplete() {
            @Override
            public void onComplete(Prefrence prefrence) {
                Log.d("my-test", "onComplete: "+prefrence.load_banner());
            }
        }, new Ads_Manager.onError() {
            @Override
            public void onError(Exception e) {
                Log.d("my-test", "onError: "+e.getMessage());
            }
        });
    }
}