package com.example.satoru.viewsample;

import android.content.DialogInterface;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v("MainActivity","Hello Androidが選択されました");

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_LONG).show();

            }
        });
        builder.setNeutralButton("Nutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                ImageView imageView=new ImageView(MainActivity.this);
                Toast toast = Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                imageView.setImageResource(R.mipmap.ic_launcher);
                toast.setView(imageView);
                toast.show();
            }
        });
        builder.show();

        return true;


    }
}
