package com.skyworth.mycwn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.artifex.mupdfdemo.ChoosePDFActivity;
import com.artifex.mupdfdemo.MuPDFActivity;
import com.skyworth.mycwn.databinding.ActivityMainBinding;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'mycwn' library on application startup.
    static {
        System.loadLibrary("mycwn");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textViewJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.fromFile(new File("/storage/emulated/0/123.pdf"));
                Intent intent = new Intent(MainActivity.this, MuPDFActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });

    }

    /**
     * A native method that is implemented by the 'mycwn' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}