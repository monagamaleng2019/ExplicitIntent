package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity3 extends AppCompatActivity {
    EditText edit;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
    edit = findViewById(R.id.editText2);
    btn =findViewById(R.id.button);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(edit.getText().toString().isEmpty())
            {
                Toast.makeText(getApplicationContext(),"enter yoyr name",Toast.LENGTH_SHORT).show();
            }
            else
                {

                Intent back = new Intent();
                back.putExtra("surname",edit.getText().toString());
                setResult(RESULT_OK,back);

                 
                }

        }
    });


    }
}
