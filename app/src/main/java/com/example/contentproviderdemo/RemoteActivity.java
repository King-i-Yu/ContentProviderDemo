package com.example.contentproviderdemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class RemoteActivity extends AppCompatActivity {
    private IMyAidlInterface mBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
        Bundle bundle = getContentResolver().call(Uri.parse("content://com.example.mycontentprovider"), "getData", null, null);
        mBinder = IMyAidlInterface.Stub.asInterface(bundle.getBinder("binder"));
        try {
            Log.i("kingiyu", "RemoteActivity-->-->onCreate-->" + mBinder.getData());
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("kingiyu", "RemoteActivity-->-->exception-->" + e);
        }
    }
}
