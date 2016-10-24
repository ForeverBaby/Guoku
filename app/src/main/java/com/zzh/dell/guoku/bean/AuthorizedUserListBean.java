package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/10/20.
 */
public class AuthorizedUserListBean implements Parcelable{

    List<Account.UserBean> authorized_user;
    int count;
    int page;

    protected AuthorizedUserListBean(Parcel in) {
        authorized_user = in.createTypedArrayList(Account.UserBean.CREATOR);
        count = in.readInt();
        page = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(authorized_user);
        dest.writeInt(count);
        dest.writeInt(page);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AuthorizedUserListBean> CREATOR = new Creator<AuthorizedUserListBean>() {
        @Override
        public AuthorizedUserListBean createFromParcel(Parcel in) {
            return new AuthorizedUserListBean(in);
        }

        @Override
        public AuthorizedUserListBean[] newArray(int size) {
            return new AuthorizedUserListBean[size];
        }
    };

    public List<Account.UserBean> getAuthorized_user() {
        return authorized_user;
    }

    public void setAuthorized_user(List<Account.UserBean> authorized_user) {
        this.authorized_user = authorized_user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
