package com.example.chenpusheng.realmexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenpusheng.realmexample.R;
import com.example.chenpusheng.realmexample.realmobject.Person;

/**
 * Created by chenpusheng on 2015/10/15.
 */
public class PersonsAdapter extends RealmRecyclerViewAdapter<Person> {
    private PersonsHolder personsHolder;

    private class PersonsHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView age;

        public PersonsHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_item, viewGroup, false);
        personsHolder = new PersonsHolder(viewItem);
        return personsHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        PersonsHolder personsHolder = (PersonsHolder) viewHolder;
        Person person = getItem(i);
        personsHolder.name.setText(person.getName());
        personsHolder.age.setText(person.getAge());

    }

    @Override
    public int getItemCount() {
        if (getRealmAdapter() != null) {
            return getRealmAdapter().getCount();
        }

        return 0;
    }
}
