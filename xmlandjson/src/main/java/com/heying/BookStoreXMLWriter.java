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

public class BookStoreXMLWriter {
    /**
     *添加一本书到xml文件里
     * @param book
     * */
    public static void addBook(Book book) throws DocumentException, IOException {
        //获取xml文档对象Document
        File xmlFile = new File("D:\\JavaFinally-xf\\untitled\\xmlandjson\\bookstore.xml");
        SAXReader reader = new SAXReader();
        Document xmlDoc = reader.read(xmlFile);
        Element root = xmlDoc.getRootElement();
        final Element bookEl = root.addElement("book");
        bookEl.addAttribute("category", book.getCategory());
        final Element titleEl = bookEl.addElement("title");
        titleEl.addAttribute("lang", book.getLang());
        titleEl.setText(book.getTitle());
        bookEl.addElement("author").setText(book.getAuthor());
        bookEl.addElement("year").setText(book.getYear());
        bookEl.addElement("price").setText(book.getPrice()+"");

        FileWriter fw = new FileWriter("bookstore2.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(fw,format);
        writer.write(xmlDoc);
        writer.close();
    }

    public static void main(String[] args) throws DocumentException, IOException {
        final Book book = new Book("Java", "cn", "xf", "2000", 20.0,
                "学习");
        addBook(book);
    }
}
