package com.tzadikiel.server;

import com.tzadikiel.adder.ResourceAdder;
import com.tzadikiel.remover.ResourceRemover;
import com.tzadikiel.resource.ElementsResource;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer {

    public static void main(String[] args) throws InterruptedException {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;

        ElementsResource resource = new ElementsResource();


        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            while(true) {

                sc = servidor.accept();

//                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();
                System.out.println(mensaje);
                if(mensaje.contains("add")) {
                    ResourceAdder adder = new ResourceAdder(resource, mensaje.substring(4));
                    adder.start();
                    adder.join();
                    out.writeUTF(resource.getElements().toString());
                } else if(mensaje.contains("remove")){
                    ResourceRemover remover = new ResourceRemover(resource);
                    remover.start();
                    remover.join();
                    out.writeUTF(resource.getElements().toString());
                } else {
                    out.writeUTF("Comando incorrecto");
                }

//                sc.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
