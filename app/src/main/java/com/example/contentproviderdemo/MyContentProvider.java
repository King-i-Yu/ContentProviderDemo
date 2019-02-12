package com.example.contentproviderdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Author wangyu1
 * Data 2019/2/12
 * Description
 **/
public class MyContentProvider extends ContentProvider {
    private BinderParcel mBinderParcel = new BinderParcel();

    public int delete(Uri arg0, String arg1, String[] arg2) {
        return 0;
    }

    public String getType(Uri arg0) {
        return null;
    }

    public Uri insert(Uri arg0, ContentValues arg1) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3, String arg4) {
        return null;
    }

    public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
        return 0;
    }

    @Override
    public Bundle call(@NonNull String method, @Nullable String arg, @Nullable Bundle extras) {
        if (!TextUtils.isEmpty(method) && TextUtils.equals(method, "setData")) {
            mBinderParcel.mProxy = extras.getBinder("binder");
        } else if (!TextUtils.isEmpty(method) && TextUtils.equals(method, "getData")) {
            Bundle bundle = new Bundle();
            bundle.putBinder("binder", mBinderParcel.mProxy);
            return bundle;
        }
        return null;
    }
}
