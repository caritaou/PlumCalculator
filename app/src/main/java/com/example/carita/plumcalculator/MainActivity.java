package com.example.carita.plumcalculator;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
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
    Button clear, plus, minus, equal;

    StringBuilder stack = new StringBuilder("");    //holds current number entered
    String operator = "";   //current operator
    int number = 0;         //left number in the equation
    int answer = MAX7DIGIT; //answer to the equation
    boolean solved = false; //state of equation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);
        addButtons();
    }

    /**
     * Button listeners for the keypad
     */
    public void addButtons() {
        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) { //if user hit "=" and then a number, continue the equation
                    reset();
                }
                stack.append("1");
                screen.append("1");
            }
        });

        two = (Button) findViewById(R.id.two);
        two.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                stack.append("2");
                screen.append("2");
            }
        });

        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                stack.append("3");
                screen.append("3");
            }
        });

        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                stack.append("4");
                screen.append("4");
            }
        });

        five = (Button) findViewById(R.id.five);
        five.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                stack.append("5");
                screen.append("5");
            }
        });

        six = (Button) findViewById(R.id.six);
        six.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                stack.append("6");
                screen.append("6");
            }
        });

        seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                stack.append("7");
                screen.append("7");
            }
        });

        eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                stack.append("8");
                screen.append("8");
            }
        });

        nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                stack.append("9");
                screen.append("9");
            }
        });

        zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solved) {
                    reset();
                }
                //if leading zero, do nothing. else append to stack
                if (stack.length() != 0){
                    stack.append("0");
                    screen.append("0");
                }
            }
        });

        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //if user hit "+" after "="
                if (solved && stack.length() == 0){
                    solved = false;
                    screen.append(" ");
                }

                //if user hit "+" after entering a number
                if (stack.length() != 0){
                    //if there are no previous record of an operator, record the first number
                    if (operator.length() == 0){
                        screen.append(" ");
                        number = Integer.parseInt(stack.toString());
                    }
                    //if there is already an operator, then perform calculation and display result
                    if (operator.length() != 0) {
                        number = calculate(number, Integer.parseInt(stack.toString()), operator);
                        answer = number;
                        screen.append(" ");
                        String output = "<font color ='#0020C2'>" + String.valueOf(answer) + "</font>";
                        screen.append(Html.fromHtml(output));
                        screen.append(" ");
                    }
                    operator = "+"; //set the current operator to "+"
                    stack = new StringBuilder();
                }
                else {
                    operator = "+"; //set the current operator to "+"
                }
            }
        });

        minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //if user hit "-" after "="
                if (solved && stack.length() == 0){
                    solved = false;
                    screen.append(" ");
                }

                //if user hit "-" after entering a number
                if (stack.length() != 0){
                    //if there are no previous record of an operator, record the first number
                    if (operator.length() == 0){
                        screen.append(" ");
                        number = Integer.parseInt(stack.toString());
                    }
                    //if there is already an operator, then perform calculation and display result
                    if (operator.length() != 0) {
                        number = calculate(number, Integer.parseInt(stack.toString()), operator);
                        answer = number;
                        screen.append(" ");
                        String output = "<font color ='#0020C2'>" + String.valueOf(answer) + "</font>";
                        screen.append(Html.fromHtml(output));
                        screen.append(" ");
                    }
                    operator = "-"; //set the current operator to "-"
                    stack = new StringBuilder();
                }
                else {
                    operator = "-"; //set the current operator to "-"
                }
            }
        });

        equal = (Button) findViewById(R.id.equal);
        equal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!solved) {
                    //if user entered two numbers and an operator followed by equal
                    if (number != 0 && operator.length() != 0 && stack.length() != 0) { // 1 + 1 =
                        number = calculate(number, Integer.parseInt(stack.toString()), operator);
                        answer = number;
                        stack = new StringBuilder();
                        operator = "";
                    }
                    //if user entered a number and a operator followed by equal
                    else if (number != 0 && operator.length() != 0) { //1 + =
                        answer = number;
                        operator = "";
                    }
                    //if user entered a number followed by equal
                    else if (number == 0 && operator.length() == 0 && stack.length() != 0){ //1 =
                        number = Integer.parseInt(stack.toString());
                        answer = number;
                        stack = new StringBuilder();
                    }
                    //if the answer is different than MAX7DIGIT, print to screen. else the user did not enter an equation
                    if(answer != MAX7DIGIT) {
                        screen.append(" ");
                        String output = "<font color ='#0020C2'>" + String.valueOf(answer) + "</font>";
                        screen.append(Html.fromHtml(output));
                        solved = true;
                    }
                }
            }
        });
    }

    /**
     * Performs addition or subtraction given two numbers and an operator
     * @param a first number in equation
     * @param b second number in equation
     * @param op operator
     * @return the sum or difference between a and b
     */
    public int calculate(int a, int b, String op) {
        int eval = 0;
        switch (op){
            case "+":
                eval = a + b;
                break;
            case "-":
                eval = a - b;
                break;
        }
        return eval;
    }

    /**
     * Resets all values for next equation
     */
    public void reset() {
        screen.setText("");
        stack = new StringBuilder("");
        operator = "";
        number = 0;
        answer = MAX7DIGIT;
        solved = false;
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
