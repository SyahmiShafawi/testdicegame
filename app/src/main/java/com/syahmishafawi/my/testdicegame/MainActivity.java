package com.syahmishafawi.my.testdicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnSort;

    ImageView imageViewdice ;
    TextView Title, textViewRound;

    RelativeLayout RelativePlayer;
    TextView textViewPlayer1List,textViewPlayer2List,textViewPlayer3List,textViewPlayer4List;
    TextView textViewPlayer1, textViewPlayer2, textViewPlayer3, textViewPlayer4;

    private Random rng = new Random();
    int randomNumber,i;

    ArrayList<Integer> player1List = new ArrayList<Integer>();
    ArrayList<Integer> player2List = new ArrayList<Integer>();
    ArrayList<Integer> player3List = new ArrayList<Integer>();
    ArrayList<Integer> player4List = new ArrayList<Integer>();

    int countround = 1;
    int count1=0;
    int count2=0;
    int count3=0;
    int count4=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewdice = findViewById(R.id.imageViewdice);
        textViewRound = findViewById(R.id.textViewRound);
        Title = findViewById(R.id.Title);

        imageViewdice.setVisibility(View.VISIBLE);
        Title.setVisibility(View.VISIBLE);
        textViewRound.setVisibility(View.GONE);

        RelativePlayer = findViewById(R.id.RelativePlayer);
        textViewPlayer1List = findViewById(R.id.textViewPlayer1List);
        textViewPlayer2List = findViewById(R.id.textViewPlayer2List);
        textViewPlayer3List = findViewById(R.id.textViewPlayer3List);
        textViewPlayer4List = findViewById(R.id.textViewPlayer4List);

        textViewPlayer1 = findViewById(R.id.textViewPlayer1);
        textViewPlayer2 = findViewById(R.id.textViewPlayer2);
        textViewPlayer3 = findViewById(R.id.textViewPlayer3);
        textViewPlayer4 = findViewById(R.id.textViewPlayer4);

        RelativePlayer.setVisibility(View.GONE);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewdice.setVisibility(View.GONE);
                Title.setVisibility(View.GONE);
                textViewRound.setVisibility(View.VISIBLE);

                RelativePlayer.setVisibility(View.VISIBLE);

                textViewPlayer1.setText("Player 1");
                textViewPlayer2.setText("Player 2");
                textViewPlayer3.setText("Player 3");
                textViewPlayer4.setText("Player 4");


                startrolldice();
                btnStart.setText("Next Round");
            }
        });


        btnSort = findViewById(R.id.btnSort);
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rollnextdice();
            }
        });


        btnStart.setVisibility(View.VISIBLE);
        btnSort.setVisibility(View.GONE);
    }

    public void startrolldice(){

        count1=0;
        count2=0;
        count3=0;
        count4=0;

        if(player1List!=null && player1List.size()>0){
            countround++;

            textViewRound.setText("Round " +countround );

            Log.d("Nextround", "++++++++++++++++++++++"+"Round "+countround+"++++++++++++++++++++");

            for (i = 0; i < player1List.size(); i++) {
                randomNumber = rng.nextInt(6) + 1;
                player1List.set(i,randomNumber);

            }

            for (i = 0; i < player2List.size(); i++) {
                randomNumber = rng.nextInt(6) + 1;
                player2List.set(i,randomNumber);

            }

            for (i = 0; i < player3List.size(); i++) {
                randomNumber = rng.nextInt(6) + 1;
                player3List.set(i,randomNumber);

            }

            for ( i = 0; i < player4List.size(); i++) {
                randomNumber = rng.nextInt(6) + 1;
                player4List.set(i,randomNumber);

            }

            System.out.println(player1List);
            System.out.println(player2List);
            System.out.println(player3List);
            System.out.println(player4List);

            textViewPlayer1List.setText(String.valueOf(player1List));
            textViewPlayer2List.setText(String.valueOf(player2List));
            textViewPlayer3List.setText(String.valueOf(player3List));
            textViewPlayer4List.setText(String.valueOf(player4List));

            btnStart.setVisibility(View.GONE);
            btnSort.setVisibility(View.VISIBLE);


            Log.d("roundend", "--------------------------------------------");
        }
        else{

            player1List.clear();
            player2List.clear();
            player3List.clear();
            player4List.clear();

            countround = 1;
            textViewRound.setText("Round " +countround );

            Log.d("gamestart", "***************** "+"Round "+ countround +" **************************");

            for ( i = 0; i < 6; i++) {
                randomNumber = rng.nextInt(6) + 1;
                player1List.add(randomNumber);

            }

        for ( i = 0; i < 6; i++) {
            randomNumber = rng.nextInt(6) + 1;
            player2List.add(randomNumber);

        }

        for ( i = 0; i < 6; i++) {
            randomNumber = rng.nextInt(6) + 1;
            player3List.add(randomNumber);

        }

        for ( i = 0; i < 6; i++) {
            randomNumber = rng.nextInt(6) + 1;
            player4List.add(randomNumber);

        }

        System.out.println(player1List);
        System.out.println(player2List);
        System.out.println(player3List);
        System.out.println(player4List);

            textViewPlayer1List.setText(String.valueOf(player1List));
            textViewPlayer2List.setText(String.valueOf(player2List));
            textViewPlayer3List.setText(String.valueOf(player3List));
            textViewPlayer4List.setText(String.valueOf(player4List));


        btnStart.setVisibility(View.GONE);
        btnSort.setVisibility(View.VISIBLE);


        Log.d("roundend", "--------------------------------------------");
        }
    }

    public void rollnextdice(){


        if(player1List!=null && player1List.size()>0){

            for(Iterator<Integer> it1 = player1List.iterator();it1.hasNext();){

                Integer value = it1.next();
                if(value == 6)
                    it1.remove();
                else if(value == 1){
                    count1++;
                    it1.remove();
                }

            }
            System.out.println(count1);
        }

        if(player2List!=null && player2List.size()>0){

            for(Iterator<Integer> it2 = player2List.iterator();it2.hasNext();){

                Integer value = it2.next();
                if(value == 6)
                    it2.remove();
                else if(value == 1){
                    count2++;
                    it2.remove();
                }

            }
            System.out.println(count2);
        }

        if(player3List!=null && player3List.size()>0){

            for(Iterator<Integer> it3 = player3List.iterator();it3.hasNext();){

                Integer value = it3.next();
                if(value == 6)
                    it3.remove();
                else if(value == 1){
                    count3++;
                    it3.remove();
                }

            }
            System.out.println(count3);
        }

        if(player4List!=null && player4List.size()>0){

            for(Iterator<Integer> it4 = player4List.iterator();it4.hasNext();){

                Integer value = it4.next();
                if(value == 6)
                    it4.remove();
                else if(value == 1){
                    count4++;
                    it4.remove();
                }

            }
            System.out.println(count4);
        }

        for(int i = 0; i < count1; i++)
            player2List.add(1);

        for(int i = 0; i < count2; i++)
            player3List.add(1);

        for(int i = 0; i < count3; i++)
            player4List.add(1);

        for(int i = 0; i < count4; i++)
            player1List.add(1);

        System.out.println(player1List);
        System.out.println(player2List);
        System.out.println(player3List);
        System.out.println(player4List);

        textViewPlayer1List.setText(String.valueOf(player1List));
        textViewPlayer2List.setText(String.valueOf(player2List));
        textViewPlayer3List.setText(String.valueOf(player3List));
        textViewPlayer4List.setText(String.valueOf(player4List));

        if(player1List.size()== 0){

            btnStart.setVisibility(View.VISIBLE);
            btnSort.setVisibility(View.GONE);

            Log.d("Player1win", "##################### Player1 Win! #######################");
            textViewPlayer1.setText("Player 1 WIN!!!");
            btnStart.setText("Start");


        }else{
            btnStart.setVisibility(View.VISIBLE);
            btnSort.setVisibility(View.GONE);
        }
        if(player2List.size()== 0){

            btnStart.setVisibility(View.VISIBLE);
            btnSort.setVisibility(View.GONE);

            Log.d("Player2win", "##################### Player2 Win! #######################");
            textViewPlayer2.setText("Player 2 WIN!!!");
            btnStart.setText("Start");

        }else{
            btnStart.setVisibility(View.VISIBLE);
            btnSort.setVisibility(View.GONE);
        }
        if(player3List.size()== 0){

            btnStart.setVisibility(View.VISIBLE);
            btnSort.setVisibility(View.GONE);

            Log.d("Player3win", "##################### Player3 Win! #######################");
            textViewPlayer3.setText("Player 3 WIN!!!");
            btnStart.setText("Start");

        }else{
            btnStart.setVisibility(View.VISIBLE);
            btnSort.setVisibility(View.GONE);
        }
        if(player4List.size()== 0){

            btnStart.setVisibility(View.VISIBLE);
            btnSort.setVisibility(View.GONE);

            Log.d("Player4win", "##################### Player4 Win! #######################");
            textViewPlayer4.setText("Player 4 WIN!!!");
            btnStart.setText("Start Again");

        }else{
            btnStart.setVisibility(View.VISIBLE);
            btnSort.setVisibility(View.GONE);
        }

        if(player1List.size()== 0 || player2List.size()== 0 || player3List.size()== 0 || player4List.size()== 0){
            player1List.clear();
            player2List.clear();
            player3List.clear();
            player4List.clear();

            Log.d("Player4win", "##################### New Game Start #######################");
        }
    }


}
