package com.grimschitz.grimschitz_einzelarbeit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.grimschitz.grimschitz_einzelarbeit.isPrime;

public class MainActivity extends AppCompatActivity {
    private TCPClient client;
    private isPrime prime;
    TextView output;
    EditText martriklFeld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.respons);
        martriklFeld = (EditText) findViewById(R.id.matrikelnummer);
        this.client = new TCPClient();
        this.prime = new isPrime();

    }
    public void send(View view) {
        String str = client.getMsg(martriklFeld.getText().toString());
        char[] numberOnly= str.replaceAll("[^0-9]", "").toCharArray();
        output.setText(prime.primes(numberOnly));
    }
}