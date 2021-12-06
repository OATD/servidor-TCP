package com.tzadikiel.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPClient {
    public static void main(String[] args) {
        //Host del servidor
        final String HOST = "127.0.0.1";
        //Puerto del servidor
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        Scanner inKeyboard = new Scanner(System.in);

        while(true) {
            try {
                Socket sc = new Socket(HOST, PUERTO);

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String entrada = inKeyboard.nextLine();
                if(!entrada.equals("x")) {
                    out.writeUTF(entrada);
                } else {
                    sc.close();
                }

                String mensaje = in.readUTF();

                System.out.println(mensaje);

            } catch (IOException ex) {
                Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
