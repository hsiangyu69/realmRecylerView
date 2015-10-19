package com.example.chenpusheng.realmexample.adapter;

import android.support.v7.widget.RecyclerView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;

/**
 * Created by chenpusheng on 2015/10/15.
 */
public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter {
    private RealmBaseAdapter<T> realmBaseAdapter;

    public void setRealmAdapter(RealmBaseAdapter<T> realmAdapter) {
        realmBaseAdapter = realmAdapter;
    }

    public T getItem(int postion) {
        return realmBaseAdapter.getItem(postion);
    }

    public RealmBaseAdapter getRealmAdapter() {
        return  realmBaseAdapter;
    }
}
