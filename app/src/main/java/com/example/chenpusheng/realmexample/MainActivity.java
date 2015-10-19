package com.example.chenpusheng.realmexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chenpusheng.realmexample.adapter.PersonsAdapter;
import com.example.chenpusheng.realmexample.adapter.RealmPersonsAdapter;
import com.example.chenpusheng.realmexample.realmobject.Person;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private PersonsAdapter personsAdapter;
    private RecyclerView recyclerView;
    private Realm realm;
    private List<Person> personList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getInstance(this);


        Person person = new Person();
        person.setName("Apple");
        person.setAge("12");
        personList.add(person);
        Person person1 = new Person();
        person1.setName("Orange");
        person1.setAge("24");
        personList.add(person1);
        PersonDatabaseHelper.getInstance().addPersonList(realm, personList);


//        PersonDatabaseHelper.getInstance().addPerson(realm, "Tom", "29");
//        PersonDatabaseHelper.getInstance().addPerson(realm, "Judy", "88");

        personsAdapter = new PersonsAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        RealmResults<Person> persons = PersonDatabaseHelper.getInstance().findAllPerson(realm);
        RealmPersonsAdapter realmPersonsAdapter = new RealmPersonsAdapter(this, persons, true);
        personsAdapter.setRealmAdapter(realmPersonsAdapter);
        personsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

//    public void addPerson(String name, String age) {
//        realm.beginTransaction();
//        Person person = realm.createObject(Person.class);
//        person.setName(name);
//        person.setAge(age);
//        realm.commitTransaction();
//
//    }


}
