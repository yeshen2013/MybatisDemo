package com.lyyexample.communication.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liuyangyang on 2018/8/19.
 */
public class TcpService {

    private static ServerSocket serverSocket;

    public static void main(String[] args){
        try {
            if(serverSocket == null){
                serverSocket =new ServerSocket(10002);
                serverSocket.setSoTimeout(60000);
            }
            System.out.println("服务器开始监听！");
            Socket accept = serverSocket.accept();
            while(true){
                BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
                if(bufferedInputStream.available()>0){
                    byte[] receive = new byte[1024];
                    bufferedInputStream.read(receive);
                    System.out.println("服务端收到消息："+new String(receive));
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(accept.getOutputStream());
                    String response = "服务器已收到！";
                    bufferedOutputStream.write(response.getBytes());
                    bufferedOutputStream.flush();
                } else {
                    Thread.sleep(50);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
