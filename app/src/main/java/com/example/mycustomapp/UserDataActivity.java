package com.example.mycustomapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Retrofit;

import android.os.Bundle;

import java.util.ArrayList;

public class UserDataActivity extends AppCompatActivity {

    //en esta activity es donde vamos a hacer las llamadas a retrofit
    ArrayList<String> listData;
    RecyclerView recycler;

    //empezamos con el RecyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);


        recycler = (RecyclerView) findViewById(R.id.recyclerviewRepos);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //aqui es donde pondremos el nombre de los repos
        listData = new ArrayList<String>();
        for(int i=0; i<=20; i++){
            listData.add("Data"+i+"");
        }


        //mandamos la lista de datos que hemos creado
        AdapterData adapterData = new AdapterData(listData);
        recycler.setAdapter(adapterData);


    }


    //arriba tenemos todavía no está implementado el recycler está instaciado pero no se rellena de momento
    //con los datos de la APi de Github con cada repo de cada diferente usuario
    private void getPosts(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/users/").build();
    }

}