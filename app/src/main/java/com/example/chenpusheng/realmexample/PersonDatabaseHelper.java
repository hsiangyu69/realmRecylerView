package com.example.chenpusheng.realmexample;

import com.example.chenpusheng.realmexample.realmobject.Person;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by HsiangYu on 2015/10/16.
 */
public class PersonDatabaseHelper {
    private static PersonDatabaseHelper instance = new PersonDatabaseHelper();

    public static PersonDatabaseHelper getInstance() {
        return instance;
    }



    public void addPerson(Realm realm, String name, String age) {
        realm.beginTransaction();
        Person person = realm.createObject(Person.class);
        person.setName(name);
        person.setAge(age);
        realm.commitTransaction();

    }

    public RealmResults<Person> findAllPerson(Realm realm) {
        RealmResults<Person> persons = realm.where(Person.class).findAll();
        return persons;
    }

    public void addPersonList(Realm realm, List<Person> personList) {
        realm.beginTransaction();
        realm.copyToRealm(personList);
        realm.commitTransaction();
    }

    public void clearAllPersonObject(Realm realm){
        realm.beginTransaction();
        realm.where(Person.class).findAll().clear();
        realm.commitTransaction();
    }
}
