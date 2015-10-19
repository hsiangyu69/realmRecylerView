package com.example.chenpusheng.realmexample.adapter;

import android.content.Context;

import com.example.chenpusheng.realmexample.realmobject.Person;

import io.realm.RealmResults;

/**
 * Created by chenpusheng on 2015/10/16.
 */
public class RealmPersonsAdapter extends RealmModelAdapter<Person> {
    public RealmPersonsAdapter(Context context, RealmResults realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
