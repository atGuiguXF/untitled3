package com.heying;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookStoreXmlParser {
    public static void main(String[] args) throws DocumentException {
        //获取xml文档对象Document
        File xmlFile = new File("D:\\JavaFinally-xf\\untitled\\xmlandjson\\bookstore.xml");
        SAXReader reader = new SAXReader();
        Document xmlDoc = reader.read(xmlFile);

        //获取根元素对象
        Element root = xmlDoc.getRootElement();
        //获取根元素名称
        final String name = root.getName();

        //获取所有直接子元素的对象集合
        final List<Element> bookElList = root.elements();
        List<Book> list = new ArrayList<>();
        bookElList.forEach(bookEL -> {
            String category = bookEL.attributeValue("category");
            final Element titleEl = bookEL.element("title");
            final String lang = titleEl.attributeValue("lang");
            final String title = titleEl.getText();
            final String author = bookEL.elementText("author");
            final String year = bookEL.elementText("year");
            final double price = Double.parseDouble(bookEL.elementText("price"));
            list.add(new Book(title, lang, author, year
                    , price, category));

        });

        System.out.println(list);
    }

}
