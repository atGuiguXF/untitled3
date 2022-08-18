package com.heying;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

public class TestXpath {
    public static void main(String[] args) throws DocumentException {
        File xmlFile = new File("D:\\JavaFinally-xf\\untitled\\xmlandjson\\bookstore.xml");
        //再创建dom4j的读取文件类，来读取xml文件
        SAXReader reader = new SAXReader();
        Document xmlDoc = reader.read(xmlFile);
        System.out.println(xmlDoc.selectNodes("//book[price>30]"));
    }
}
