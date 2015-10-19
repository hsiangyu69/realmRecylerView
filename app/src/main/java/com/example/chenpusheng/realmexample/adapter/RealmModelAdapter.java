package com.example.chenpusheng.realmexample.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by chenpusheng on 2015/10/15.
 */
public class RealmModelAdapter<T extends RealmObject>  extends RealmBaseAdapter{
    public RealmModelAdapter(Context context, RealmResults realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
