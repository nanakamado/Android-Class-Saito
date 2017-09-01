package com.example.satoru.activitysample;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Next2Activity extends AppCompatActivity {

    int resultCode=RESULT_CANCELED;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        TextView textView = (TextView)findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void onClickAlertButton(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resultCode = RESULT_OK;
            }

        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resultCode =RESULT_CANCELED;

            }
        });
        builder.show();


    }


    public void onClickFinishButton(View view) {
        EditText editText = (EditText)findViewById(R.id.result_message);
        String message = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("result_message", message);
        setResult(result, intent);

        finish();
    }
}
