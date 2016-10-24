package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DELL on 2016/10/24.
 */
public class Tag implements Parcelable{
    int category_count;
    int group_id;
    int status;
    String title;
    public Tag(){}

    protected Tag(Parcel in) {
        category_count = in.readInt();
        group_id = in.readInt();
        status = in.readInt();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(category_count);
        dest.writeInt(group_id);
        dest.writeInt(status);
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tag> CREATOR = new Creator<Tag>() {
        @Override
        public Tag createFromParcel(Parcel in) {
            return new Tag(in);
        }

        @Override
        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };

    public int getCategory_count() {
        return category_count;
    }

    public void setCategory_count(int category_count) {
        this.category_count = category_count;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
