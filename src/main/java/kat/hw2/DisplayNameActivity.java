package kat.hw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_name);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(name);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_name);
        layout.addView(textView);
    }
}
