package com.example.eno_shica_cho;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static int[] arr = new int[9]; //data storage of a play
    public int[][] ar = {{0,3,6},{1,4,7},{2,5,8},{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}}; //winning position
    private static int apk = 0;
    public static int count =0;
    /*
    : 1: shicamaru
    : 2: chogi
     */

    public static int activePlayer =1;




    @SuppressLint("SetTextI18n")


    public void play(View view){
        ImageView a = (ImageView) view;
        int bid = Integer.parseInt(a.getTag().toString());
        if (apk==-1){
            restartt(view);
            return;
        }
        apk++;
        if (apk>0){
            if (arr[bid]==0){
                count++;
                a.setTranslationY(-1000f);
                if (activePlayer==1){
                    arr[bid]=1;
                    a.setImageResource(R.drawable.shica);
                    TextView turn = findViewById(R.id.turn);
                    turn.setText("Turn : Player 2");
                }
                else{
                    arr[bid]=2;
                    a.setImageResource(R.drawable.cho);
                    TextView turn = findViewById(R.id.turn);
                    turn.setText("Turn : Player 1");
                }
                a.animate().translationYBy(1000f).setDuration(400);
                //System.out.println(Arrays.toString(arr));
                //Intent n = new Intent(this,oaa.class);
                for (int[] ints : ar) {
                    if (arr[ints[0]] == activePlayer && arr[ints[1]] == activePlayer && arr[ints[2]] == activePlayer) {
                        System.out.println(" m");
                        TextView turn = findViewById(R.id.turn);
                        turn.setText("Winner : Player" + activePlayer);
                        Toast.makeText(this, "Winner : Player" + activePlayer, Toast.LENGTH_LONG).show();
                        apk=-1;
                        break;
                    }
                }
                if (activePlayer==1){
                    activePlayer=2;
                }else {
                    activePlayer=1;
                }
                if (count==9){
                    Toast.makeText(this, "Tie    \n Play Again", Toast.LENGTH_SHORT).show();
                    restartt(view);
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void restartt(View view){
        if (apk==-1){
            ((ImageView)findViewById(R.id.c1)).setImageResource(R.drawable.eno);
            ((ImageView)findViewById(R.id.c2)).setImageResource(R.drawable.eno);
            ((ImageView)findViewById(R.id.c3)).setImageResource(R.drawable.eno);
            ((ImageView)findViewById(R.id.c4)).setImageResource(R.drawable.eno);
            ((ImageView)findViewById(R.id.c5)).setImageResource(R.drawable.eno);
            ((ImageView)findViewById(R.id.c6)).setImageResource(R.drawable.eno);
            ((ImageView)findViewById(R.id.c7)).setImageResource(R.drawable.eno);
            ((ImageView)findViewById(R.id.c8)).setImageResource(R.drawable.eno);
            ((ImageView)findViewById(R.id.c9)).setImageResource(R.drawable.eno);
            arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            activePlayer=1;
            TextView turn = findViewById(R.id.turn);
            turn.setText("Turn : Player 1");
            apk++;
            count=0;
            return;
        }
        apk=0;
        arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        activePlayer=1;
        TextView turn = findViewById(R.id.turn);
        turn.setText("Turn : Player 1");
        count=0;
        ((ImageView)findViewById(R.id.c1)).setImageResource(R.drawable.eno);
        ((ImageView)findViewById(R.id.c2)).setImageResource(R.drawable.eno);
        ((ImageView)findViewById(R.id.c3)).setImageResource(R.drawable.eno);
        ((ImageView)findViewById(R.id.c4)).setImageResource(R.drawable.eno);
        ((ImageView)findViewById(R.id.c5)).setImageResource(R.drawable.eno);
        ((ImageView)findViewById(R.id.c6)).setImageResource(R.drawable.eno);
        ((ImageView)findViewById(R.id.c7)).setImageResource(R.drawable.eno);
        ((ImageView)findViewById(R.id.c8)).setImageResource(R.drawable.eno);
        ((ImageView)findViewById(R.id.c9)).setImageResource(R.drawable.eno);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}