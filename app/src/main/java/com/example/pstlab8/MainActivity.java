package com.example.pstlab8;

//import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etnombres, etapellidos, etphone, etmail;
    Intent emailIntent = new Intent(Intent.ACTION_SEND);
    //boolean check= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnombres = (EditText)findViewById(R.id.editTextFirstname);
        etapellidos = (EditText)findViewById(R.id.editTextSecondname);
        etphone = (EditText)findViewById(R.id.editTextPhone);
        etmail = (EditText)findViewById(R.id.editTextMail);

    }

    public void enviar (View v){
        String[] to = {"btigrero@espol.edu.ec"};
        String[] cc = {/*"steamleo@fiec.espol.edu.ec"*/};
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Formulario de Registro PST");

        emailIntent.putExtra(Intent.EXTRA_TEXT, "Datos de Contacto\n" +
                "Nombres:" + etnombres.getText().toString()+ "\n" +
                "Apellidos:" + etapellidos.getText().toString() +"\n" +
                "Teléfono:" + etphone.getText().toString() + "\n" +
                "Correo Electrónico:" + etmail.getText().toString()+ "\n");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviando Email"));
            Log.i("termina envio de email", "");
            //welcome();
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No existe cliente Email instalado.", Toast.LENGTH_SHORT).show();
        }
        //welcome(v);
}

    public void welcome (View v) {
        Intent i = new Intent(this,welcome.class);
        i.putExtra("name","Nombres:" + etnombres.getText().toString()+ "\n");
        i.putExtra("subname","Apellidos:" + etapellidos.getText().toString() +"\n");
        i.putExtra("phone","Teléfono:" + etphone.getText().toString() + "\n");
        i.putExtra("mail","Correo Electrónico:" + etmail.getText().toString()+ "\n");
        startActivity(i);
    }

}
