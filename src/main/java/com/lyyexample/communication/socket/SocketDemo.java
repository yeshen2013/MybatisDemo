package com.lyyexample.communication.socket;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by liuyangyang on 2018/8/18.
 */
public class SocketDemo {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(SocketDemo.class);

    @Value("${socket.host:127.0.0.1}")
    private static String host;

    @Value("${socket.port:10001}")
    private static int port;

    private static Socket socket;

    private static ServerSocket serverSocket;

    public void connect(){
        try{
            if(socket != null){
                socket.close();
                socket = null;
            }
            socket = new Socket(host,port);
            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read("dsdf".getBytes());
            String send = "发送消息";

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(send.getBytes());
            outputStream.flush();
        }catch (IOException e){
            logger.info(e.getMessage());
        }finally {
            System.out.printf("dd");
        }

    }

    public static void clientSend(String msg){
        try{
            if(socket == null){
                socket = new Socket(host,port);
            }
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(msg.getBytes());
            outputStream.flush();
            InputStream inputStream = socket.getInputStream();
            byte[] receive = new byte[100];
            int read = inputStream.read(receive);
            System.out.println("客服端收到消息："+receive.toString());
        }catch (IOException e){
            logger.info(e.getMessage());
        }
    }


    public static void serviceReceive(String responseMsg){
        try {
            if(serverSocket == null){
                serverSocket =new ServerSocket(10001);
            }
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] receive = new byte[100];
            inputStream.read(receive);
            System.out.println("服务端收到消息："+receive.toString());
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write(responseMsg.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            serverSocket = new ServerSocket(10001);
        } catch (IOException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始聊天");
        System.out.println("请输入：");
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            clientSend(s);
            System.out.println("请回复：");
            String r = scanner.nextLine();
            serviceReceive(r);
        }
    }

}
