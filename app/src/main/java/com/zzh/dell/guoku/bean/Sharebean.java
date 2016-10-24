package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DELL on 2016/10/22.
 */
public class Sharebean implements Parcelable{
    String aricleId;
    String aricleUrl;
    String context;
    String imgUrl;
    private boolean is_dig;
    String title;
    public Sharebean(){}

    protected Sharebean(Parcel in) {
        aricleId = in.readString();
        aricleUrl = in.readString();
        context = in.readString();
        imgUrl = in.readString();
        is_dig = in.readByte() != 0;
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(aricleId);
        dest.writeString(aricleUrl);
        dest.writeString(context);
        dest.writeString(imgUrl);
        dest.writeByte((byte) (is_dig ? 1 : 0));
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Sharebean> CREATOR = new Creator<Sharebean>() {
        @Override
        public Sharebean createFromParcel(Parcel in) {
            return new Sharebean(in);
        }

        @Override
        public Sharebean[] newArray(int size) {
            return new Sharebean[size];
        }
    };

    public String getAricleId() {
        return aricleId;
    }

    public void setAricleId(String aricleId) {
        this.aricleId = aricleId;
    }

    public String getAricleUrl() {
        return aricleUrl;
    }

    public void setAricleUrl(String aricleUrl) {
        this.aricleUrl = aricleUrl;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean is_dig() {
        return is_dig;
    }

    public void setIs_dig(boolean is_dig) {
        this.is_dig = is_dig;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
