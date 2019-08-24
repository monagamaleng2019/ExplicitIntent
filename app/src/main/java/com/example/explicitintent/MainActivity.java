package com.example.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare main activity components
final int activity3 = 3;

    EditText edit;
    Button btnActivity2;
    Button btnActivity3;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.editText);
        btnActivity2 = findViewById(R.id.buttonActivity1);
        btnActivity3 = findViewById(R.id.buttonActivity2);
        txtView =findViewById(R.id.textView);

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edit.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"enter your name",Toast.LENGTH_SHORT).show();
                }
                else {
                    String name = edit.getText().toString().trim();
                    Intent x = new Intent(getApplicationContext(), activity2.class);
                    x.putExtra("data",name);
                    startActivity(x);
                }

            }
        });

        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         Intent go3 = new Intent(getApplicationContext(), activity3.class);
            startActivityForResult(go3,activity3);


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == activity3){

            if(resultCode == RESULT_OK)
            {
                String str = data.getStringExtra("surname");
                txtView.setText(str);
            }
            if(resultCode == RESULT_CANCELED)
            {
                txtView.setText("no data recievd");
            }

        }

        else {}

    }
}
