
package com.example.parthmakadiya.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactUs extends AppCompatActivity {
    EditText name;
    MultiAutoCompleteTextView desc;
    Button submit,auth,clr,logout;
    TextView google;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase, mfb;
    private String mUserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        google=(TextView)findViewById(R.id.textView3);
        google.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.google, 0, 0, 0);

        desc = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        submit = (Button) findViewById(R.id.btnSubmit);
        clr = (Button) findViewById(R.id.btnclear);
        auth = (Button) findViewById(R.id.btnAuth);
        logout=(Button)findViewById(R.id.btnLogout);
        final EditText text = (EditText) findViewById(R.id.editText2);
        final Button button = (Button) findViewById(R.id.btnSubmit);

        // Initialize Firebase Auth and Database Reference
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (mFirebaseUser == null) {
            // Not logged in, launch the Log In activity
            loadLogInView();
        } else {
            mUserId = mFirebaseUser.getUid();
            // Add items via the Button and EditText at the bottom of the view.


            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    mDatabase.child("users").child(mUserId).child("items").push().child("title").setValue(text.getText().toString());
//                    mDatabase.child("users").child(mUserId).child("items").push().child("Desc").setValue(desc.getText().toString());

                    mfb = mDatabase.child("users").child("feedback").push();
                    mfb.child("title").setValue("Title : "+text.getText().toString());
                    mfb.child("Desc").setValue("Description : "+desc.getText().toString());


                    text.setText("");
                    desc.setText("");
                }
            });
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logout
                mFirebaseUser=null;
                loadLogInView();
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                desc.setText("");
            }
        });
    }

    private void loadLogInView() {
        Intent intent = new Intent(this, Signin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

