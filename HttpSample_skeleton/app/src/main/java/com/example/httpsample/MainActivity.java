package com.example.httpsample;

import android.app.DownloadManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "HttpClientSample";
    TextView textView;

    // 実習 1,2 接続先URL ネットワーク接続可
    private static final String URL = "http://httpbin.org/get";

    // 実習 1,2 ネットワーク接続不可
    // private static final String URL = "http://[PCのIPアドレス]:8080/oesf.html";

    // 実習3 接続先URL
    private static final String SCHEME = "http";
    private static final String HOST = "iss.ndl.go.jp";
    private static final String PATH = "api/opensearch";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 【HTTP通信 実習2】 No.01 TextViewの初期化
        textView=(TextView)findViewById(R.id.text_content);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    }

    public void onClickButton(View view) {
        // TODO 【HTTP通信 実習3】No.01 変数urlのコメントアウト
        //String url = URL;

        // TODO 【HTTP通信 実習1】No.01 OktHttpClientオブジェクトの生成する
        OkHttpClient httpClient =new OkHttpClient();

        // TODO 【HTTP通信 実習3】No.02 EditTextから入力値を取得する
        EditText editKey = (EditText) findViewById(R.id.editKey);
        EditText editValue = (EditText) findViewById(R.id.editValue);
        String key = editKey.getText().toString();
        String value = editValue.getText().toString();


        // TODO 【HTTP通信 実習3】No.03 WebAPI用クエリパラメータのの作成
        HttpUrl url = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegments(PATH)
                .addQueryParameter(key, value)
                .build();

        //TODO 【HTTP通信 実習1】No.02 URLを指定してリクエストを生成する


        Request.Builder builder =new Request.Builder();
        builder.url(url);
        builder.get();
        Request request =builder.build();

        try {
            // TODO 【HTTP通信 実習1】No.03 リクエストを発行してレスポンスを取得する
            Response response = httpClient.newCall(request).execute();
            // TODO 【HTTP通信 実習1】No.04 ステータスコードのチェックする
            //以下のコードのコメントアウトを解除して、if文の条件式を入力す
                // TODO 【HTTP通信 実習1】No.05 ログを出力する
            if (response.isSuccessful()){
            Log.v(TAG, "status ok");

                // TODO 【HTTP通信 実習2】 No.02 コンテンツデータの取得
                String content =response.body().string();
                // TODO 【HTTP通信 実習2】 No.03 TextViewに取得したコンテンツデータを表示
                textView.setText(content);
            }else{
               Log.v(TAG, "status code=" + response.code());
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

    }


}
