package com.example.contentproviderdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                try {
                    DataManager.getServerStub().addData(9);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                bundle.putBinder("binder", DataManager.getServerStub());
                getContentResolver().call(Uri.parse("content://com.example.mycontentprovider"), "setData", null, bundle);
                startActivity(new Intent(MainActivity.this, RemoteActivity.class));
            }
        });
    }
}
