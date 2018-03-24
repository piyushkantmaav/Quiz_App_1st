package com.example.hppc.app20;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    Random random;
    TextView expression;
    Button button0;
    Button button1;
    Button button2;
    Button button3;


    int correctAnswerPosition;
    int inCorrectOption;
    int count = 0;
    Handler handler;

    TextView result;
    ArrayList<Integer> options  = new ArrayList<Integer>();

    public void startGame(View view){
        button.setVisibility(View.INVISIBLE);


    }

    public void checkAnswer(View view){
        String tag = (String)view.getTag().toString();
        if(tag.equals(Integer.toString(correctAnswerPosition))){
            result.setText("Correct");

        }else{
            result.setText("Incorrect");
        }

         handler = new Handler();

        count= 0;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                count++;
                if(count<3){
                    handler.postDelayed(this,1000);
                }else{
                    showNew();
                    result.setText("");
                }
            }
        };
        handler.post(runnable);





       // Log.i("Tag",ob.toString());

    }
    void showNew(){

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        expression.setText(a+"+"+b);

       correctAnswerPosition = random.nextInt(4);
       options.clear();
       for(int i=0;i<4;i++){

           if(i==correctAnswerPosition){
               options.add(a+b);


           }else{
               inCorrectOption = random.nextInt(41);
               while(inCorrectOption==(a+b)){
                   inCorrectOption = random.nextInt(41);
               }
               options.add(inCorrectOption);
           }
       }
       button0.setText(Integer.toString(options.get(0)));
       button1.setText(Integer.toString(options.get(1)));
       button2.setText(Integer.toString(options.get(2)));
       button3.setText(Integer.toString(options.get(3)));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.startButton);
        random = new Random();
        expression  = findViewById(R.id.expression);
        result = findViewById(R.id.result);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        showNew();
    }

}
