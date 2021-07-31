package com.example.pstlab8;

        import android.os.Bundle;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class welcome extends AppCompatActivity {
    TextView tvnombres, tvapellidos, tvphone, tvmail;
  //  boolean check= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        welcome2();
    }

    public void welcome2 (){

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        tvnombres=(TextView) findViewById(R.id.editTextFirstname);
        tvnombres.setText(name);
        String subname = extras.getString("subname");
        tvapellidos=(TextView) findViewById(R.id.editTextSecondname);
        tvapellidos.setText(subname);
        String phone = extras.getString("phone");
        tvphone=(TextView) findViewById(R.id.editTextPhone);
        tvphone.setText(phone);
        String mail = extras.getString("mail");
        tvmail=(TextView) findViewById(R.id.editTextMail);
        tvmail.setText(mail);

    }

}
