package com.lyyexample.communication.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by liuyangyang on 2018/8/19.
 */
public class UdpClient {

    public static void main(String[] args){
        try {
            InetAddress address = InetAddress.getByName("localhost");
            int port =10010;
            byte[] data ="用户名密码".getBytes();
            DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
            DatagramSocket datagramSocket = new DatagramSocket();

            datagramSocket.send(packet);

            byte[] data2 = new byte[1024];
            DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
            datagramSocket.receive(packet2);
            String reply = new String(data2,0,packet2.getLength());
            System.out.println("我是客户端，服务器说："+reply);
            datagramSocket.close();
        } catch (Exception e){
            e.getStackTrace();
        }
    }
}
