package com.example.satoru.activitysample;

import android.content.Intent;
import android.database.CursorJoiner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNextButton(View view) {
        EditText editText =(EditText)findViewById(R.id.edit_message);
        Intent intent = new Intent(this, NextActivity.class);
        String message = editText.getText().toString();
        intent.putExtra("message",message);
        startActivityForResult(intent, 123);
    }

    public void onClickNext2Button(View view) {
        EditText editText = (EditText)findViewById(R.id.edit_message);
        Intent intent = new Intent(this, Next2Activity.class);
        String message = editText.getText().toString();
        intent.putExtra("message",message);
        startActivityForResult(intent, 456);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "requestCode = " +requestCode);
        Log.d(TAG,"requestCode = "+ requestCode);


        TextView textForm =(TextView)findViewById(R.id.text_form);
        TextView textResult =(TextView)findViewById(R.id.text_result);
        TextView textRequest =(TextView)findViewById(R.id.text_request);
        if (requestCode ==123) {
            textForm.setText("MainActivity");
        }else{
            textForm.setText("MainActivity");

        }
        textRequest.setText("Result"+resultCode);
        textResult.setText("Result"+resultCode);

    }
}
