package com.t3ch.shaj.android_firebase_basic;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    TextView textView;

    EditText nameInput, idInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();

        nameInput = findViewById(R.id.nameTextID);
        idInput = findViewById(R.id.idTextID);

        textView = findViewById(R.id.TV_ID);


    }

    public void buttonClicked(View view) {


        String childName = nameInput.getText().toString();
        myRef = database.getReference("Users").child(childName);

        myRef.child("Name").setValue(nameInput.getText().toString());
        myRef.child("ID").setValue(idInput.getText().toString());


    }


}
