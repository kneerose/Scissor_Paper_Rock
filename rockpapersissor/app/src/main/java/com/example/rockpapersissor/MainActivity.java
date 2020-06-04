package com.example.rockpapersissor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView view1, view2, score1, score2,gameover;
    Button button2;
    Integer score11 = 0, score22 = 0;
    ImageView cimage,pimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // random value
        final Random rand = new Random();
        //for alert message
        final AlertDialog alertDialog = new AlertDialog.Builder(
                MainActivity.this).create();
        //for player 1
        view1 = findViewById(R.id.view1);
        // button1 = findViewById(R.id.button1);
        score1 = findViewById(R.id.score1);
       /* button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to generate random int value(0,1,2)
                Integer a = rand.nextInt(3);
                if(a.equals(0)) {
                    view1.setText("Scissor");
                }
                else if (a.equals(1))
                {
                    view1.setText("Paper");
                }
                else{
                    view1.setText("Rock");
                }
            }
        });*/
        //for player 2
        view2 = findViewById(R.id.view2);
        button2 = findViewById(R.id.button2);
        score2 = findViewById(R.id.score2);
        score1.setText("0");
        score2.setText("0");
        gameover = findViewById(R.id.go);
        cimage = findViewById(R.id.cimage);
        pimage = findViewById(R.id.pimage);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer b = rand.nextInt(3);
                if (b.equals(0)) {
                    pimage.setImageResource(R.drawable.scissor);
                } else if (b.equals(1)) {
                    pimage.setImageResource(R.drawable.paper);
                } else {
                    pimage.setImageResource(R.drawable.rock);
                }
                Integer a = rand.nextInt(3);
                if (a.equals(0)) {
                    cimage.setImageResource(R.drawable.scissor);
                } else if (a.equals(1)) {
                    cimage.setImageResource(R.drawable.paper);
                } else {
                    cimage.setImageResource(R.drawable.rock);
                }
                if (a.equals(0) && b.equals(1)) {
                    score11++;
                    score1.setText(score11.toString());
                    gameover.setText("Computer scored");
                } else if (a.equals(0) && b.equals(2)) {
                    score22++;
                    score2.setText(score22.toString());
                    gameover.setText("Player Scored");
                }
                    else if (a.equals(1) && b.equals(0)) {
                        score22++;
                        score2.setText(score22.toString());
                    gameover.setText("Player Scored");
                    } else if (a.equals(1) && b.equals(2)) {
                        score11++;
                        score1.setText(score11.toString());
                    gameover.setText("Computer scored");
                    } else if (a.equals(2) && b.equals(1)) {
                        score22++;
                        score2.setText(score22.toString());
                    gameover.setText("Player Scored");
                    } else if (a.equals(2) && b.equals(0)) {
                        score11++;
                        score1.setText(score11.toString());
                    gameover.setText("Computer scored");
                }
                    else {
                        gameover.setText("Draw");
                }
                if (score1.getText().equals("10")) {
                    Toast.makeText(getApplicationContext(),"Computer won",Toast.LENGTH_SHORT).show();
                    gameover.setText("computer won \n\ngame over");
                    score11=0;
                    score22=0;
                    score1.setText("0");
                    score2.setText("0");
                } else if (score2.getText().equals("10")) {
                   Toast.makeText(getApplicationContext(),"Player won",Toast.LENGTH_SHORT).show();
                    gameover.setText("Player won \n\ngame over");
                    score11=0;
                    score22=0;
                    score1.setText("0");
                    score2.setText("0");
                }

            }
        });


    }
}