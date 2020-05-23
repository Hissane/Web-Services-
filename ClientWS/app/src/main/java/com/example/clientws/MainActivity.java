package com.example.clientws;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView TxtId;
    TextView TxtNom;
    TextView TxtPrenom;
    Button btnAdd;
    Button btnDelete;
    RecyclerView mCont;
    RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TxtId=(TextView)findViewById(R.id.editTextId);
        TxtNom=(TextView)findViewById(R.id.editTextNom);
        TxtPrenom=(TextView)findViewById(R.id.editTextPrenom);
        btnAdd=(Button)findViewById(R.id.buttonAdd);
        btnDelete=(Button)findViewById(R.id.buttonDelete);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = TxtId.getText().toString();
                String nom = TxtNom.getText().toString();
                String prenom = TxtPrenom.getText().toString();
                new Thread(new Runnable() {
                    @Override public void run() {
                        try {
                            URL urlService=new URL("http://192.168.1.2:8080/WSContact/contact/");
                            HttpURLConnection urlCnx =(HttpURLConnection) urlService.openConnection();
                            urlCnx.setRequestMethod("POST");
                            InputStream in = new BufferedInputStream(urlCnx.getInputStream());
                            //final Contact leContact =gson.fromJson(sc.nextLine(), Contact.class);
                            //runOnUiThread(new Runnable() {
                            //  @Override
                            //public void run() {
                            //  txtFluxJSON.setText(leContact.toString());
                            //}
                            //});
                            //runOnUiThread(new Runnable() {
                            //public void run() {
                            //StringBuilder s=new StringBuilder();
                            // for (Contact c: lesContacts)
                            //    s.append(c.toString()+"\n"); txtFluxJSON.setText(s);
                            // }
                            // });
                        } catch (Exception e) {e.printStackTrace();}
                    }
                }).start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override public void run() {
                try {
                    URL urlService=new URL("http://192.168.1.2:8080/WSContact/contact/");
                    HttpURLConnection urlCnx =(HttpURLConnection) urlService.openConnection();
                    urlCnx.setRequestMethod("GET");
                    InputStream in = new BufferedInputStream(urlCnx.getInputStream());
                    Scanner sc=new Scanner(in);
                    Gson gson=new GsonBuilder().create();
                    //final Contact leContact =gson.fromJson(sc.nextLine(), Contact.class);
                    final Contact[] lesContacts =gson.fromJson(sc.nextLine(), Contact[].class);
                    //runOnUiThread(new Runnable() {
                      //  @Override
                        //public void run() {
                          //  txtFluxJSON.setText(leContact.toString());
                        //}
                    //});
                    //runOnUiThread(new Runnable() {
                        //public void run() {
                            //StringBuilder s=new StringBuilder();
                           // for (Contact c: lesContacts)
                            //    s.append(c.toString()+"\n"); txtFluxJSON.setText(s);
                       // }
                   // });
                    mCont = (RecyclerView)findViewById(R.id.recyclerView);
                    mAdapter = new RecyclerAdapter( MainActivity.this, Arrays.asList(lesContacts));
                    mCont.setAdapter(mAdapter);
                    mCont.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                } catch (Exception e) {e.printStackTrace();}
            }
        }).start();
    }


}