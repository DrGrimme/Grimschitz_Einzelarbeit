package com.grimschitz.grimschitz_einzelarbeit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TCPClient client;
    TextView output;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.respons);
        this.client = new TCPClient();
    }
    public void send(View view) {
        output.setText(client.getMsg(findViewById(R.id.matrikelnummer).toString()));
    }
}