package com.example.empty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recording_data extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Button location = findViewById(R.id.record);

        location.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Recording_data.this, MapsActivity.class);
            startActivity(intent);
        }
    });
    }
}





//@Override
//protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.fragment_second);
//
//    Button recorder = findViewById(R.id.editLocation);
//
//    recorder.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent intent=new Intent(Secondfragment.this, MapsActivity.class);
//            startActivity(intent);
////                setContentView(R.layout.fragment_second);
//        }
//    });
//}
//}





////package com.example.empty;
////
////import android.os.Bundle;
////import android.view.View;
////import android.widget.Button;
////
////import androidx.fragment.app.FragmentActivity;
////
////public class Recording_data extends FragmentActivity {
////
////    private Button location, polygon, submit;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.fragment_second);
////
////        location = findViewById(R.id.editLocation);
////        polygon =  findViewById(R.id.txtPolygon);
////        submit = findViewById(R.id.bSubmit);
////
////        location.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                setContentView(R.layout.activity_main);
////            }
////        });
////        polygon.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                setContentView(R.layout.activity_main);
////            }
////        });
////        submit.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                setContentView(R.layout.activity_main);
////            }
////        });
////    }
////
////}
//
//package com.example.empty;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.widget.Button;
//
//
//public class Recording_data extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_second);
//
//        Button location = findViewById(R.id.editLocation);
//        Button polygon = findViewById(R.id.txtPolygon);
//        Button submit = findViewById(R.id.bSubmit);
//
//        location.setOnClickListener(v -> setContentView(R.layout.fragment_second));
//        polygon.setOnClickListener(v -> setContentView(R.layout.fragment_second));
//        submit.setOnClickListener(v -> setContentView(R.layout.fragment_second));
//    }
//
//}
//
