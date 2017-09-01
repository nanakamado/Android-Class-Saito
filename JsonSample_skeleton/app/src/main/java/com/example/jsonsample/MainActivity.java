package com.example.jsonsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView textResult;
    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = (TextView) findViewById(R.id.text_result);
        getData();
    }

    public void onClickClearButton(View view) {
        textResult.setText("");
    }

    public void onClickJsonButton(View view) {
        ArrayList<Item> list = JsonHelper.parseJson(json);
        StringBuilder sb = new StringBuilder();
        for (Item item : list) {
            sb.append(item.toString());
        }
        textResult.setText(sb.toString());
    }

    /**
     * assetsフォルダからsample.jsonファイルを読み込む
     */
    private void getData() {
        BufferedReader br = null;
        try {
            InputStream in = getAssets().open("sample.json");
            br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                Log.v("getData", line);
                sb.append(line);
            }
            json = sb.toString();
            Log.v("getData", json);

        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
    }
}
