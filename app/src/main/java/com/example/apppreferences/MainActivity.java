package com.example.apppreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences preferences = getPreferences(MODE_PRIVATE);

        final TextView textView1 = findViewById(R.id.textView1);
        final TextView textView2 = findViewById(R.id.textView2);

        Button buttonGenerar = findViewById(R.id.buttonGenerar);
        Button buttonResetear = findViewById(R.id.buttonResetear);

        textView1.setText(String.valueOf(preferences.getInt("valor_maximo",0)));
        textView2.setText(String.valueOf(preferences.getInt("valor_maximo",0)));

        buttonGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int valor = r.nextInt();

                textView2.setText(String.valueOf(valor));

                if (valor > preferences.getInt("valor_maximo",0)){
                    SharedPreferences.Editor editor =  preferences.edit();
                    editor.putInt("valor_maximo",valor);
                    editor.commit();

                    textView1.setText(String.valueOf(valor));
                }
            }
        });

        buttonResetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
