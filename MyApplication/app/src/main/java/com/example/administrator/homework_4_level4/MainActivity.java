package com.example.administrator.homework_4_level4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import java.text.DecimalFormat;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mNumberText;
    private Button mybtn0, mybtn1, mybtn2, mybtn3, mybtn4, mybtn5, mybtn6, mybtn7, mybtn8, mybtn9;
    private Button myplus;
    private Button myminus;
    private Button mymultiply;
    private Button mydivide;
    private Button myanswer;
    private Button myC;
    public double result = 0;
    private Stack<String> mMathStack = new Stack<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberText = (TextView) findViewById(R.id.tv1);
        mNumberText.setText("请输入数据！");
        mybtn0 = (Button) findViewById(R.id.btn0);
        mybtn1 = (Button) findViewById(R.id.btn1);
        mybtn2 = (Button) findViewById(R.id.btn2);
        mybtn3 = (Button) findViewById(R.id.btn3);
        mybtn4 = (Button) findViewById(R.id.btn4);
        mybtn5 = (Button) findViewById(R.id.btn5);
        mybtn6 = (Button) findViewById(R.id.btn6);
        mybtn7 = (Button) findViewById(R.id.btn7);
        mybtn8 = (Button) findViewById(R.id.btn8);
        mybtn9 = (Button) findViewById(R.id.btn9);
        myplus = (Button) findViewById(R.id.btnPlus);
        myminus = (Button) findViewById(R.id.btnMinus);
        mymultiply = (Button) findViewById(R.id.btnMultiply);
        mydivide = (Button) findViewById(R.id.btnDivide);
        myanswer = (Button) findViewById(R.id.btnanswer);
        myC = (Button) findViewById(R.id.btnC);

        mybtn0.setOnClickListener(this);
        mybtn1.setOnClickListener(this);
        mybtn2.setOnClickListener(this);
        mybtn3.setOnClickListener(this);
        mybtn4.setOnClickListener(this);
        mybtn5.setOnClickListener(this);
        mybtn6.setOnClickListener(this);
        mybtn7.setOnClickListener(this);
        mybtn8.setOnClickListener(this);
        mybtn9.setOnClickListener(this);
        myplus.setOnClickListener(this);
        myminus.setOnClickListener(this);
        mymultiply.setOnClickListener(this);
        mydivide.setOnClickListener(this);
        myanswer.setOnClickListener(this);
        myC.setOnClickListener(this);
    }

    //入栈~
    private void push(char obj) {
        final int size = mMathStack.size();
        if ('c' == obj) {
            mMathStack.clear();
            //刚进去的时候

            return;
        }
        // 加、减、乘、除、等鱼的处理
        if ('+' == obj || '-' == obj || '*' == obj || '/' == obj || '=' == obj) {
            switch (size) {
                case 0:
                    break;
                case 2:
                    if ('=' != obj)
                        mMathStack.set(1, obj + "");
                    break;
                case 1:
                    if ('=' != obj)
                        mMathStack.push(obj + "");
                    break;
                case 3:
                    DecimalFormat mFormat = new DecimalFormat("###############");
                    String preResult = mFormat.format(calculate());
                    mMathStack.push(preResult);
                    if ('=' != obj)
                        mMathStack.push(obj + "");
                    mNumberText.setText(preResult);
                    break;
            }
            return;
        }

        String str = "";
        int location = 0;
        switch (size) {
            case 0:
                mMathStack.push("");
            case 1:
                // str = mMathStack.push();
                break;
            case 2:
                mMathStack.push("");
            case 3:
                location = 2;
                str = mMathStack.peek();
                break;
        }

        int len = str.length();
        str += obj;
        mMathStack.set(location, str);
        mNumberText.setText(str);
    }

    //用个double，万一以后还想着去写算小数的呢哈哈
    private double calculate() {
        double right, left;
        if (mMathStack.size() == 3) {
            //right = parseDouble(mMathStack.push());
            right = otherclass(mMathStack.pop());
            String oper = mMathStack.pop();
            left = otherclass(mMathStack.pop());
            if ("+".equals(oper)) {
                result = left + right;
            } else if ("-".equals(oper)) {
                result = left - right;
            } else if ("*".equals(oper)) {
                result = left * right;
            } else if ("/".equals(oper)) {
                if (right != 0)
                    result = left / right;
            }
        }
        return result;
    }

    private double otherclass(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMultiply:
                push('*');
                break;
            case R.id.btnDivide:
                push('/');
                break;
            case R.id.btnMinus:
                push('-');
                break;
            case R.id.btnPlus:
                push('+');
                break;
            case R.id.btnC:
                push('c');
                break;
            case R.id.btn0:
                push('0');
                break;
            case R.id.btn1:
                push('1');
                break;
            case R.id.btn2:
                push('2');
                break;
            case R.id.btn3:
                push('3');
                break;
            case R.id.btn4:
                push('4');
                break;
            case R.id.btn5:
                push('5');
                break;
            case R.id.btn6:
                push('6');
                break;
            case R.id.btn7:
                push('7');
                break;
            case R.id.btn8:
                push('8');
                break;
            case R.id.btn9:
                push('9');
                break;
            case R.id.btnanswer:
                push('=');
                Toast.makeText(MainActivity.this, "算出来啦", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

