package com.lokiiichauhan.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MESSAGE_ID = "message_prefs";
    private EditText enterMessage;
    private Button saveButton;
    private TextView showMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = findViewById(R.id.button);
        enterMessage = findViewById(R.id.message_editext);
        showMessageTextView = findViewById(R.id.show_message_textview);

        saveButton.setOnClickListener(view ->{
            String message = enterMessage.getText().toString().trim();

            SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("message", message);

            editor.apply();

        });

        SharedPreferences getSharedData = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
        String value = getSharedData.getString("message", "Nothing");
        showMessageTextView.setText(value);
    }
}