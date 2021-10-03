package com.satyam.sqlcruddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.satyam.sqlcruddemo.Data.MyDBHandler;
import com.satyam.sqlcruddemo.model.Contact;
import com.satyam.sqlcruddemo.params.Params;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

        MyDBHandler dbHandler = new MyDBHandler(MainActivity.this);
//        Contact sat = new Contact();
//        sat.setName("sat");
//        sat.setPhoneNumber("4565764844");
//        dbHandler.addContact(sat);
//
//        Contact siva = new Contact();
//        siva.setName("Shiva");
//        siva.setPhoneNumber("7687767565");
//        dbHandler.addContact(siva);
//
//        siva.setId(1);
//        siva.setName("satyampra");
//        siva.setPhoneNumber("9793828742");

//        int affectedRows=dbHandler.updateContact(siva);
//
//        Contact Gilie=new Contact();
//        Gilie.setName("Gilie");
//        Gilie.setPhoneNumber("8787960697");
//        dbHandler.addContact(Gilie);
        ArrayList<String >arrayList=new ArrayList<>();

        List<Contact> allContacts = dbHandler.getAllContacts();
        for (Contact contact : allContacts) {
            dbHandler.deleteContact(1);
            dbHandler.deleteContact(4);
            dbHandler.deleteContact(5);
            arrayList.add(contact.getName()+"("+contact.getPhoneNumber()+")");
//            Log.d("dbsatyam", "\nId: " + contact.getId() + "\n" +
//                    "Name: " + contact.getName() + "\n" +
//                    "Phone Number: " + contact.getPhoneNumber() + "\n");

        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

//        Log.d("dbsatyam", "the number of affected rows"+affectedRows);
//        Log.d("dbsatyam","the number of columns avalileble"+dbHandler.getCount());

    }
}