package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test {
    private static OutputStream outputStream;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 1313);
            System.out.println(socket);
            InputStream stream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            int len = 4096;
            byte[] buffer;
            buffer = new byte[len];
            int realLen = stream.read(buffer);
            System.out.println("realLen :"+realLen +  " buffer.length:"+buffer.length);
            if (realLen != -1 && buffer.length != realLen) {
//                buffer = subByteArray(buffer, 0, realLen);
//                String result = new String(buffer);
//                String array[] = result.split(" |\n");

//                banner.setVersion(Integer.valueOf(array[1]));
//                banner.setMaxPoint(Integer.valueOf(array[3]));
//                banner.setMaxPress(Integer.valueOf(array[6]));
//                banner.setMaxX(Integer.valueOf(array[4]));
//                banner.setMaxY(Integer.valueOf(array[5]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
