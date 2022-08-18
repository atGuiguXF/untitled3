package com.heying;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class NoteXmlParser {
    public static void main(String[] args) throws DocumentException {
        //首先创建一个xml文件，使用dom4j，先创建文件，将文件引入。
        File xmlFile = new File("D:\\JavaFinally-xf\\untitled\\xmlandjson\\note.xml");
        //再创建dom4j的读取文件类，来读取xml文件
        SAXReader reader = new SAXReader();
        Document xmlDoc = reader.read(xmlFile);
        Element root = xmlDoc.getRootElement();

        final String to = root.elementText("to");
        final String from = root.elementText("from");
        final String heading = root.elementText("heading");
        final String body = root.elementText("body");

        System.out.println(from+" to "+to+" say:"+heading+"."+body);
    }
}
