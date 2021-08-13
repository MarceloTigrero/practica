package com.example.pstlab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class ConexionRemota extends AppCompatActivity {
    private TextView query ;
    private EditText query2,condicion;
    private String servidor = "192.168.100.68";//ip
    private int puerto = 8080;//puerto
    //http://localhost:8080/android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conexion_remota);
        query=(TextView) findViewById(R.id.textoconexion);
        query2=(EditText) findViewById(R.id.query);
        condicion=(EditText) findViewById(R.id.condicion);
    }
    public void Conectar(View v){
        String resultado = null;
        try {
            String datos = "http://"+servidor+":"+puerto+"/android";
            AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();
            if(resultado != null)
                query.setText(resultado);
            else
                query.setText("Error desconocido en la consulta");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*public void consultar(View view){
        String resultado = null;
        try {
            String datos = "http://"+servidor+":"+puerto+"/android/"+query2.getText().toString();
            AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();
            query.setText(resultado);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
    public void consultar(View view){
        String resultado = null;
        String consulta1 = "Select * FROM "+query2.getText().toString().trim();
        String validacion = condicion.getText().toString().trim();
        String consulta2 = "Select * FROM "+query2.getText().toString().trim()+" WHERE "+validacion;
        try {
            if (validacion.isEmpty()){
                String datos = "http://"+servidor+":"+puerto+"/android/"+consulta1;
                AsyncQuery async = new AsyncQuery();
                resultado = async.execute(datos).get();
                query.setText(resultado);
            }else {
                String datos = "http://"+servidor+":"+puerto+"/android/"+consulta2;
                AsyncQuery async = new AsyncQuery();
                resultado = async.execute(datos).get();
                query.setText(resultado);
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}