package com.example.pstlab8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InicioSeccionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_seccion);
    }
    public void bienvenido(View v){
        Intent intent = new Intent(this,BienvenidoActivity.class);
        EditText user=(EditText) findViewById(R.id.user);
        String user1 = user.getText().toString();
        EditText contra=(EditText) findViewById(R.id.contra);
        String contra1 = contra.getText().toString();
        intent.putExtra("userlog",user1);
        intent.putExtra("contralog",contra1);
        startActivity(intent);
    }
}