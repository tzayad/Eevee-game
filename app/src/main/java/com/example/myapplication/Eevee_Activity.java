package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Eevee_Activity extends AppCompatActivity {
    private TextView message, Level;
    private int counter = 0, gamelevel = 1, previousClick = 0, timeNotClicked = 0;
    private float rand;
    //private String flies;
//    ArrayList<String> stringList = new ArrayList<String>();
//    list.of<String> images []= list.of("e1","e2","e3","e4","e5","e6","e7", "e8");
//            // list.of<String> images = list.of("e1","e2","e3","e4","e5","e6","e7", "e8")
    private ImageView eevee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.ClickerCounter);
        Level = findViewById(R.id.Level);
        eevee = findViewById(R.id.eeveeImage);
        previousClick = clickTime();

        //Define and attach click listener
        eevee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapDroid();
            }
        });
    }
    private int clickTime(){
        return (int)(System.currentTimeMillis()/1000);
    }
    private void levelUp() {
        gamelevel++;
        Level.setText(String.format("Level %d", gamelevel));
        //eevee.setImageDrawable(String.format("e%d", gamelevel));
        if (gamelevel == 1) {
            eevee.setImageResource(R.drawable.eevee);
        }
        else if (gamelevel == 2) {
            eevee.setImageResource(R.drawable.e2);
        }
        else if (gamelevel == 3) {
            eevee.setImageResource(R.drawable.e3);
        }
        else if (gamelevel == 4) {
            eevee.setImageResource(R.drawable.e4);
        }
        else if (gamelevel == 5) {
            eevee.setImageResource(R.drawable.e5);
        }
        else if (gamelevel == 6) {
            eevee.setImageResource(R.drawable.e6);
        }
        else if (gamelevel == 7) {
            eevee.setImageResource(R.drawable.e7);
        }
        else if (gamelevel == 8) {
            eevee.setImageResource(R.drawable.e8);
        }
    }
    private void tapDroid() {
        counter++;
        if (counter %10 == 0) {
            levelUp();
        }
        timeNotClicked = (clickTime()-previousClick);
        //Level.setText(String.format("Level %d", timeNotClicked));
        if (timeNotClicked > (4 - 0.5*gamelevel)) {
            counter = 0;
            gamelevel = 0;
            levelUp();
        }
        previousClick = clickTime();
        message.setText(String.format("Eevee clicked %d", counter));
        eevee.setX(myRandom());
        eevee.setY(myRandom()*3 + 50);
    }
    private float myRandom() {
        rand = (float)(Math.random() * 300) -150;
        return rand;
    }
}