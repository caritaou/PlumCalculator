package com.example.carita.plumcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private static final Integer MAX7DIGIT=88888888;

    TextView screen;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button clear, plus, minus, evaluate;

    String stack = "";
    String operator = "";
    int answer = MAX7DIGIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);
        addButtons();
    }

    public void addButtons() {
        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("1");
            }
        });

        two = (Button) findViewById(R.id.two);
        two.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("2");
            }
        });

        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("3");
            }
        });

        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("4");
            }
        });

        five = (Button) findViewById(R.id.five);
        five.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("5");
            }
        });

        six = (Button) findViewById(R.id.six);
        six.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("6");
            }
        });

        seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("7");
            }
        });

        eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("8");
            }
        });

        nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("9");
            }
        });

        zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append("0");
            }
        });

        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
            }
        });

        plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(" ");
            }
        });

        minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(" ");
            }
        });

        evaluate = (Button) findViewById(R.id.equal);
        evaluate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer != MAX7DIGIT) {
                    screen.append(" ");
                    screen.append(String.valueOf(answer));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
