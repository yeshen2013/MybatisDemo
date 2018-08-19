package com.lyyexample.communication.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by liuyangyang on 2018/8/19.
 */
public class TcpService {

    private static ServerSocket serverSocket;
    public static void serviceReceive(String responseMsg){
        try {
            if(serverSocket == null){
                serverSocket = new ServerSocket(10001);
            }
            Socket accept = serverSocket.accept();
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write(responseMsg.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            if(serverSocket == null){
                serverSocket =new ServerSocket(10002);
                serverSocket.setSoTimeout(60000);
            }
            System.out.println("服务器开始监听！");
            while(true){
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                byte[] receive = new byte[100];
                inputStream.read(receive);
//                inputStream.close();
                System.out.println("服务端收到消息："+new String(receive));
                OutputStream outputStream = accept.getOutputStream();
                String response = "服务器已收到！";
                outputStream.write(response.getBytes());
                outputStream.flush();
//                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
