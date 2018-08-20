package com.lyyexample.communication.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by liuyangyang on 2018/8/19.
 */
public class UdpService {
    public static void main(String[] args){
        try {
            DatagramSocket datagramSocket =new DatagramSocket(10010);
            byte[] data =new byte[1024];
            DatagramPacket packet =new DatagramPacket(data,data.length);
            datagramSocket.receive(packet);
            String info =new String(data,0,data.length);
            System.out.println("我是服务器，客户端告诉我"+info);


            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "欢迎您！".getBytes();
            DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
            datagramSocket.send(packet2);
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
