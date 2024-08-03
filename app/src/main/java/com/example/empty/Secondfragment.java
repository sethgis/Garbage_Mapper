package com.example.empty;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Secondfragment extends  AppCompatActivity {
    EditText name_space,phone_edit,describe_edit,country_edit,cons_edit,ward_edit;
    String d1,d2,d3,d4,d5,d6;
    Button recorder;
//    TextView txtV1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        recorder = findViewById(R.id.editLocation);
        name_space = findViewById(R.id.editName);
        phone_edit = findViewById(R.id.editPhone);
        describe_edit = findViewById(R.id.describe);
        country_edit = findViewById(R.id.County);
        cons_edit = findViewById(R.id.constituency);
        ward_edit = findViewById(R.id.ward);

//        BreakIterator name_space;
        recorder.setOnClickListener(view -> {
            d1 = name_space.getText().toString();
            d2 = phone_edit.getText().toString();
            d3 = describe_edit.getText().toString();
            d4 = country_edit.getText().toString();
            d5 = cons_edit.getText().toString();
            d6 = ward_edit.getText().toString();
            MyDBHandler handler = new MyDBHandler(Secondfragment.this);
            handler.addemp(d1,d2,d3,d4,d5,d6);

            Bundle bundle = new Bundle();
            bundle.putString("name",d1);
            bundle.putString("phone",d2);
            bundle.putString("description",d3);
            bundle.putString("country",d4);
            bundle.putString("constituency",d5);
            bundle.putString("wards", d6);

            Intent intent=new Intent(Secondfragment.this, polygon_mapping.class);
            intent.putExtras(bundle);
            startActivity(intent);
//                setContentView(R.layout.fragment_second);
        });
    }
}



















