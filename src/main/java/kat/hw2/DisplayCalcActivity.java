package kat.hw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayCalcActivity extends AppCompatActivity {

    private Spinner spinner;
    protected TextView num1, num2, result;
    private int a, b, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_calc);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        ImageButton calcView = new ImageButton(this);


        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_calc);
        layout.addView(calcView);

        buildSpinner();
    }

    public void buildSpinner() {
        //retrieve the
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);

        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> operatorList = new ArrayList<String>();
        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("/");
        operatorList.add("*");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operatorList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void calculate(View newView) {
        a = Integer.parseInt(num1.getText().toString());
        b = Integer.parseInt(num2.getText().toString());
        String operator = spinner.getSelectedItem().toString();

        switch(operator) {
            case "+":
                answer = a + b;
                System.out.println(answer);
                break;

            case "-":
                answer = a - b;
                break;

            case "/":
                answer = a / b;
                break;

            case "*":
                answer = a * b;
                break;

            default:
                answer = -0;
                break;
        }
        result = (TextView) findViewById(R.id.result);
        result.setText(String.valueOf(answer));
    }
}
