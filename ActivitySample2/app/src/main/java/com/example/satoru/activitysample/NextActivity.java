package com.example.satoru.activitysample;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent intent = getIntent();
        String message =intent.getStringExtra("message");
        TextView textView =(TextView)findViewById(R.id.text_message);
        textView.setText(message);
    }


    public void onCkickFinishButton(View view) {
        setResult(RESULT_OK);
        finish();
    }
}
