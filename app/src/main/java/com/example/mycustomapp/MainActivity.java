package com.example.mycustomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //lamamos a los componentes
    private EditText usernameEditText;
    private TextView usernameTexView, resultTextView, resultTextView2;

    //singleton


    //aqui será donde pidamos nombre al usuario y haremos botones
    //en principio miraremos de como utilizar usernameActivity y si no la borraremos
    //este será nuestro sharedPreferences
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionamos con los campos del android
        //no he tenido mucha originalidad
        usernameEditText = (EditText) findViewById(R.id.editText);
        usernameTexView = (TextView) findViewById(R.id.textView);
        resultTextView = (TextView) findViewById(R.id.tvresult1);
        resultTextView2 = (TextView) findViewById(R.id.tvresult2);

        //cada vez que se abrá el main veremos si hay info del usuario en la api de github
        chargePreferences();

    }

    //en el onclick hacemos un conmutador por si clica a un boton o a otro
    public void onClick(View view){
        switch(view.getId()){
            case R.id.button:
                savePreferences();
                break;
            case R.id.button2:
                //creamos intent para abrir pestaña con datos usuario de la api de github
                Intent intent = new Intent(this, UserDataActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void chargePreferences(){
        //abre archivo
        SharedPreferences preferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);
        String username=preferences.getString("username", "User doesn't exist!");
        //el evento se ha hecho
        resultTextView.setText(username);
    }

    //donde guardaremos nuestras preferencias
    //generaremos fichero xml con preferencias, donde se almacenan variables y se vinculan
    public void savePreferences(){
        //primero ponemos nombre archivo
        SharedPreferences preferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);
        String username=usernameEditText.getText().toString();

        //asignamos data em el fichero de preferences
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usr", username);

        //el evento se ha hecho
        resultTextView.setText(username);

        //y acabamos con un commit para tramitar
        editor.commit();

    }
}