package com.heying.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 网络客户端
 */
public class NetClient {

    private ObjectInputStream ois;

    private ObjectOutputStream oos;

    private static NetClient netClient;

    private NetClient() throws IOException {
        Socket socket = new Socket("localhost", 8888);
        ois =  new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    public static NetClient getInstance(){
        if(null == netClient){
            try {
                netClient = new NetClient();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return netClient;
    }


    public NetMsg send(NetMsg request) throws Exception {
        oos.writeObject(request);//发送请求
        return (NetMsg) ois.readObject();//接收响应
    }
}
