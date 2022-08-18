package com.heying;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NoteXMLWriter {
    public static void main(String[] args) throws DocumentException, IOException {
        //首先创建一个xml文件，使用dom4j，先创建文件，将文件引入。
        File xmlFile = new File("D:\\JavaFinally-xf\\untitled\\xmlandjson\\note.xml");
        //再创建dom4j的读取文件类，来读取xml文件
        SAXReader reader = new SAXReader();
        Document xmlDoc = reader.read(xmlFile);

        Element root = xmlDoc.getRootElement();
        final Element dateEl = root.addElement("date");
        dateEl.setText("2020-12-22");

        FileWriter fw = new FileWriter("note2.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(fw, format);
        writer.write(xmlDoc);
        writer.close();

    }
}
