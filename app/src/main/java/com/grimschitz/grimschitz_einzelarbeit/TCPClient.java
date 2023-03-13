package com.grimschitz.grimschitz_einzelarbeit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class TCPClient extends Activity{
    /** Called when the activity is first created. */
    public PrintWriter out;
    public  BufferedReader in;
    String hostname="se2-isys.aau.at";
    int port = 53212;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getMsg(String martrknr){
        String str = "Unable";

        try {
            Log.d("DB","Trying get ip: " + hostname +"\n");

            byte[] ipAddr = new byte[] {(byte) 143, (byte) 205, (byte) 174, (byte) 165};
            InetAddress serverAddr = InetAddress.getByAddress("se2-isys.aau.at",ipAddr); //InetAddress.getByName(hostname);
            Log.d("DB","Attempt Connecting..." + hostname +"\n");
            Socket socket = new Socket(serverAddr, port);

            //made connection, setup the read (in) and write (out)
            out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //now send a message to the server and then read back the response.
            try {
                //write a message to the server
                Log.d("DB","Attempting to send message ...\n");
                out.println(martrknr);
                Log.d("DB","Message sent...\n");

                //read back a message from the server.
                Log.d("DB","Attempting to receive a message ...\n");
                str = in.readLine();
                Log.d("DB","received a message:\n" + str+"\n");

                Log.d("DB","We are done, closing connection\n");
            } catch(Exception e) {
                Log.d("DB","Error happened sending/receiving\n");

            } finally {
                in.close();
                out.close();
                socket.close();
            }

        } catch (Exception e) {
            Log.d("DB","Unable to connect...\n");
        }
        return str;
    }
}
