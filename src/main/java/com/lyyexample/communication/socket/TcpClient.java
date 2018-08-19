package com.lyyexample.communication.socket;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by liuyangyang on 2018/8/19.
 */
public class TcpClient {
    @Value("${socket.host:127.0.0.1}")
    private static String host;

    @Value("${socket.port:10002}")
    private static int port;

    private static Socket socket;

    public static void clientSend(String msg){
        try{
            if(socket == null){
                socket = new Socket(host,port);
            }
            InputStream inputStream = socket.getInputStream();
            byte[] receive = new byte[100];
            int read = inputStream.read(receive);
            System.out.println("客服端收到消息："+receive.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        try {
            if(socket == null){
                socket = new Socket("localhost",10002);
                socket.setSoTimeout(60000);
            }
            System.out.println("开始聊天");
            Scanner scanner = new Scanner(System.in);


            while (true){
                OutputStream outputStream = socket.getOutputStream();
                System.out.println("客服端请输入：");
                String s = scanner.nextLine();
                outputStream.write(s.getBytes());
                outputStream.flush();
//                outputStream.close();
                InputStream inputStream = socket.getInputStream();
                byte[] receive = new byte[100];
                int read = inputStream.read(receive);
//                inputStream.close();
                System.out.println("客服端收到消息："+new String(receive));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
