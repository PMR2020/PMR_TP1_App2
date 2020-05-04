package com.example.pmr_tp1_app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "traces";
    Button refBtnOk;
    EditText refEdtPseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");

        // Récupérer des références vers btnOK et edtPseudo
        refBtnOk = findViewById(R.id.btnOK);
        refEdtPseudo = findViewById(R.id.edtPseudo);

        refBtnOk.setOnClickListener(this);
        refEdtPseudo.setOnClickListener(this);
        // this <=> référence vers la classe MainActivity

    }

    @Override
    public void onClick(View v) {
        // Vue cliquée : paramètre
        Toast t;
        switch(v.getId()) {
            case R.id.btnOK :
                // Récupérer contenu du champ texte ?
                String s = refEdtPseudo.getText().toString();
                Log.i(TAG,"click sur btn " + s);
                t = Toast.makeText(this,"click sur btn " + s,Toast.LENGTH_SHORT);
                t.show();

                // Afficher une nouvelle activité à laquelle on passe le pseudo saisi
                Bundle b = new Bundle();
                b.putString("pseudo",s);
                Intent versA2 = new Intent(MainActivity.this,Main2Activity.class);
                versA2.putExtras(b);
                startActivity(versA2);


                break;
            case R.id.edtPseudo:
                Log.i(TAG,"click sur edt");
                t = Toast.makeText(this,"click sur edt",Toast.LENGTH_SHORT);
                t.show();
                break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onReStart");
    }


}
