package com.example.pstlab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BienvenidoActivity extends AppCompatActivity {
    String user,contra;
    TextView user1,contra1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        recibirdatos();
    }
    public void recibirdatos(){
        Bundle extras= getIntent().getExtras();
        user = extras.getString("userlog");
        contra = extras.getString("contralog");
        user1 = (TextView) findViewById(R.id.usuario);
        user1.setText(user);
    }
}