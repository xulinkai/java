package com.aggregation.mashibing.socket;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @description:
 * @author:
 * @create: 2019-09-23 23:27
 **/
public class UDPServer1 {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //UDP的8888端口
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        while (true) {
            //receive 阻塞式的方法
            datagramSocket.receive(datagramPacket);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            //DataOutputStream
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            System.out.println(dataInputStream.readLong());
        }
    }
}
