package com.grimschitz.grimschitz_einzelarbeit;

import android.app.Activity;
import android.os.Bundle;

public class isPrime extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String primes(char[] numbs){
        StringBuilder str = new StringBuilder();
        for(char x : numbs){
            int y=Character.getNumericValue(x);
            if(y!=4&&y!=6&&y!=8&&y!=9) {
                str.append(y).append(" ");
            }
        }

       /* int i=0;
        for(char x : numbs){
            for(int v=3;v<(int)x;v++)
            int y=Character.getNumericValue(x);
                if(y%v==0) {
                    v = y+1;
                }
                else{
                    if(v>=y-1){
                        str = str. + y;
                        i++;
                    }
                }
        }*/

    return str.toString();


    }

}
