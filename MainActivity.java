package com.example.zero_kanta;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int turn = 1;
    int temp = 0;
    int gamestate[] = {0,0,0,0,0,0,0,0,0};
    int winningpositions[][]= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    Boolean active = true;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tapped(View v)
    {
        ImageView img = (ImageView) v;
        
        String tag_value = img.getTag().toString();
        //Log.i( "pressed" , tag_value);

        if (active && gamestate[Integer.parseInt(tag_value)]==0)
        {
            gamestate[Integer.parseInt(tag_value)] = turn;
            //Log.i("pressed", tag_value + "selected by player" + turn);

            count++;

            if (turn == 1) {
                img.setImageResource(R.drawable.zero);
                turn = 2;
            } else if (turn == 2) {
                img.setImageResource(R.drawable.cross);
                turn = 1;
            }

            for (int [] winningposition : winningpositions)
            {
                if (gamestate[winningposition[0]] == gamestate[winningposition[1]] && gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[0]] != 0) {
                    String winner = "";
                    if (turn == 1)
                        winner = "Player 2 won";
                    else
                        winner = "Player 1 won";
                    active = false;
                    //Toast.makeText(this, winner, Toast.LENGTH_SHORT).show();

                    Button playagainbutton = (Button) findViewById(R.id.playagainbutton);
                    TextView winnermsz = (TextView) findViewById(R.id.winnernametext);

                    winnermsz.setText(winner);

                    playagainbutton.setVisibility(View.VISIBLE);
                    winnermsz.setVisibility(View.VISIBLE);
                    temp = 1;
                }
            }
            if(count==9 && temp==0)
            {
                Button playagainbutton = (Button) findViewById(R.id.playagainbutton);
                TextView winnermsz = (TextView) findViewById(R.id.winnernametext);

                winnermsz.setText("Match Tied");

                playagainbutton.setVisibility(View.VISIBLE);
                winnermsz.setVisibility(View.VISIBLE);
            }
        }
    }

    public void playagain(View v)
    {
        Button playagainbutton = (Button) findViewById(R.id.playagainbutton);
        TextView winnermsz = (TextView) findViewById(R.id.winnernametext);

        playagainbutton.setVisibility(View.INVISIBLE);
        winnermsz.setVisibility(View.INVISIBLE);

        //removing images
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);
        ImageView imageView6 = findViewById(R.id.imageView6);
        ImageView imageView7 = findViewById(R.id.imageView7);
        ImageView imageView8 = findViewById(R.id.imageView8);
        ImageView imageView9 = findViewById(R.id.imageView9);

        imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);
        imageView7.setImageDrawable(null);
        imageView8.setImageDrawable(null);
        imageView9.setImageDrawable(null);


        turn = 1;
        for(int i = 0;i<gamestate.length;i++)
            gamestate[i]=0;
        active = true;
        count = 0;
        temp = 0;
    }
}
