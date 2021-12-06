package com.tzadikiel.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPClient {

    private static final int PUERTO = 5000;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        DataInputStream in;
        DataOutputStream out;
        Scanner inKeyboard = new Scanner(System.in);
        try {
            Socket sc = new Socket(HOST, PUERTO);
            while (!sc.isClosed()) {
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                String entrada = inKeyboard.nextLine();
                out.writeUTF(entrada);
                String mensaje = in.readUTF();
                System.out.println(mensaje);
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
