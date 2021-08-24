package com.example.pstlab8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
RRFRFRfrfrfrf
    public void iniciar(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void webview(View v){
        Intent intent = new Intent(this,WebViewActivity.class);
        startActivity(intent);
    }
    public void seccion(View v){
        Intent intent = new Intent(this,InicioSeccionActivity.class);
        startActivity(intent);
    }
    public void correo(View v){
        Intent intent = new Intent(this,RevisarCorreoActivity.class);
        startActivity(intent);
    }
    public void acerca(View v){
        Intent intent = new Intent(this,AcercaDeActivity.class);
        startActivity(intent);
    }
}