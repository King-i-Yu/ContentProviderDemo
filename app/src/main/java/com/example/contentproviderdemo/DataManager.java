package com.example.contentproviderdemo;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

/**
 * Author wangyu1
 * Data 2018/12/24
 * Description
 **/
public class DataManager {
    private static DataManager instance = null;

    private int data = 4;
    private static IMyAidlInterface.Stub mBinder = null;


    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager();
                }
            }
        }
        return instance;
    }

    public static IMyAidlInterface.Stub getServerStub() {
        if (mBinder == null) {
            mBinder = new IMyAidlInterface.Stub() {
                @Override
                public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

                }

                @Override
                public void addData(int data) throws RemoteException {
                    DataManager.getInstance().addData(data);
                }

                @Override
                public int getData() throws RemoteException {
                    return DataManager.getInstance().getData2();
                }
            };
        }

        return mBinder;
    }

    public int getData() {
        try {
            Bundle bundle = MyApplication.getInstance().getContentResolver().call(Uri.parse("content://com.example.mycontentprovider"), "getBinder", null, null);
            IMyAidlInterface mBinder = IMyAidlInterface.Stub.asInterface(bundle.getBinder("binder"));
            return mBinder.getData();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public int getData2() {
        return this.data;
    }

    public void addData(int data) {
        Log.i("kingiyu", "DataManager-->-->addData-->" + data);
        this.data = data;
    }

}
