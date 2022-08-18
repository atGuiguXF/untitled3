package com.heying.net;

import java.io.Serializable;

public class NetMsg<T> implements Serializable {

    private T data;//核心数据

    private String type;//消息的标识

    @Override
    public String toString() {
        return "NetMsg{" +
                "data=" + data +
                ", type='" + type + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NetMsg() {
    }

    public NetMsg(T data, String type) {
        this.data = data;
        this.type = type;
    }
}
