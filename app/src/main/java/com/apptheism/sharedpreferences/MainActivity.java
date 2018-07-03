package com.apptheism.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.apptheism.sharedpreferences.preferences";
    private static final String KEY_EDITTEXT = "key_edittext";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.etText);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        String editText = mSharedPreferences.getString(KEY_EDITTEXT, "");
        mEditText.setText(editText);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mEditor.putString(KEY_EDITTEXT, mEditText.getText().toString());
        mEditor.apply();
    }
}
