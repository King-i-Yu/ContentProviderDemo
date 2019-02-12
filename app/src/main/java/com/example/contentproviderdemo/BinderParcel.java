package com.example.contentproviderdemo;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author wangyu1
 * Data 2018/12/24
 * Description
 **/
public class BinderParcel implements Parcelable {
    public static final Creator<BinderParcel> CREATOR = new Creator<BinderParcel>() {
        public BinderParcel createFromParcel(Parcel arg0) {
            return BinderParcel.readFromParcel(arg0);
        }

        public BinderParcel[] newArray(int arg0) {
            return new BinderParcel[arg0];
        }
    };
    public IBinder mProxy = null;

    public BinderParcel() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeStrongBinder(this.mProxy);
    }

    public static BinderParcel readFromParcel(Parcel arg0) {
        BinderParcel bp = new BinderParcel();
        bp.mProxy = arg0.readStrongBinder();
        return bp;
    }
}