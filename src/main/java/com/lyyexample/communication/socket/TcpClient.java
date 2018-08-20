package com.lyyexample.communication.socket;

import org.springframework.beans.factory.annotation.Value;

import java.io.*;
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


    public static class Receive implements Runnable{

        @Override
        public void run() {
            if(socket == null){
                try {
                    socket = new Socket("localhost",10002);
                    socket.setSoTimeout(60000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                while (true){
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
                        if (bufferedInputStream.available() > 0){
                            byte[] receive = new byte[1024];
                            int read = bufferedInputStream.read(receive);
                            System.out.println("客服端收到消息："+new String(receive));
                        } else {
                            Thread.sleep(50);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

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
            Thread thread = new Thread(new TcpClient.Receive());
            thread.start();
            while (true){
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
                System.out.println("客服端请输入：");
                String s = "聊天结束！";
                if(!(s = scanner.nextLine()).equals("end")){
                    bufferedOutputStream.write(s.getBytes());
                    bufferedOutputStream.flush();
                } else {
                    bufferedOutputStream.write(s.getBytes());
                    bufferedOutputStream.flush();
                    break;
                }
            }
            System.exit(0);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
