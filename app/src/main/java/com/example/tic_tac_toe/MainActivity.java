package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0=X
    // 1=0
    // 2=null
    static int count=0;
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};

    public void playerTap(View view){
        ImageView img=(ImageView)view;
        int tappedImage= Integer.parseInt(img.getTag().toString());
        if(gameState[tappedImage]==2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                count++;
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status= findViewById(R.id.status);
                status.setText("O's Turn To Play");
            } else {
                count++;
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status= findViewById(R.id.status);
                status.setText("X's Turn To Play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        String str;
        if((gameState[0]==gameState[1]&&gameState[1]==gameState[2]&&gameState[0]!=2)||(gameState[3]
        ==gameState[4]&&gameState[4]==gameState[5]&&gameState[3]!=2)||(gameState[6]==gameState[7]&&
                gameState[7]==gameState[8]&&gameState[6]!=2)||(gameState[0]==gameState[3]&&
                gameState[3]==gameState[6]&&gameState[0]!=2)||(gameState[1]==gameState[4]&&
                gameState[4]==gameState[7]&&gameState[1]!=2)||(gameState[2]==gameState[5]&&
                gameState[5]==gameState[8]&&gameState[2]!=2)||(gameState[0]==gameState[4]&&
                gameState[4]==gameState[8]&&gameState[0]!=2)||(gameState[2]==gameState[4]&&
                gameState[4]==gameState[6]&&gameState[2]!=2)){
            if(activePlayer==0){
                str="O wins-Reset to Replay";
            }
            else{
                str="X wins-Reset to Replay";
               }
            TextView status=findViewById(R.id.status);
            status.setText(str);
            for(int i=0;i<gameState.length;i++){
                gameState[i]=0;
            }
        }
        else if(count==9){
            str="Tie-Tap Reset To Replay";
            TextView status=findViewById(R.id.status);
            status.setText(str);
        }
        }

    public void gameReset(View view){
        activePlayer=0;
        count=0;
        TextView status= findViewById(R.id.status);
        status.setText("X's Turn To Play" );
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
