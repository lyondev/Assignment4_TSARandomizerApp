package jlyon.greenrivertech.net.assignment4_tsarandomizerapp;

import android.graphics.LinearGradient;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyActivity extends AppCompatActivity {

    private Random randy = new Random();
    private int randomNum;
    ImageView image;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

    }

    /**
     * This method, despite its name, adds an onclick
     * listener to the whole screen and once the screen
     * is pressed generates a random number and displays
     * a random arrow accordingly.
     */
    public void addListenerOnButton(){

        image = (ImageView) findViewById(R.id.arrow); //The view element that holds the arrow image

        linearLayout = (LinearLayout) findViewById(R.id.mainView);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNum = randy.nextInt(100 - 1) + 1; //generates a random number between 1 and 100
                if (randomNum % 2 == 0) { //if number is even
                    ImageView image = (ImageView) findViewById(R.id.arrow);
                    image.setImageResource(R.drawable.leftarrow);
                } else if (randomNum % 2 == 1) { //if number is odd
                    ImageView image = (ImageView) findViewById(R.id.arrow);
                    image.setImageResource(R.drawable.rightarrow);
                }
                CountDownTimer c = new CountDownTimer(4000, 1000) { //waits 4 seconds counting down by 1 second intervals
                    @Override
                    public void onTick(long millisUntilFinished) {
                        millisUntilFinished = 4000;
                    }

                    @Override
                    public void onFinish() {
                        image.setImageResource(0); //sets imageView back to blank.
                    }
                }.start();

            }


        });

    }
}