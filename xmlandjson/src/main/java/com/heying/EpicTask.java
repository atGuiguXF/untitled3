package com.heying;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 1.将BookStore.xml-------》BookStore.txt
 * 2.BookStore.txt  ------》BookStore.xml
 */
public class EpicTask {

    private ObjectMapper objectMapper = new ObjectMapper();

    public void xml2txt() throws Exception {
        File xmlFile = new File("D:\\JavaFinally-xf\\untitled\\xmlandjson\\bookstore.xml");
        SAXReader reader = new SAXReader();
        Document xmlDoc = reader.read(xmlFile);
        Element root = xmlDoc.getRootElement();
        BufferedWriter out = null;
        try {
            final List<Element> bookElList = root.elements("book");
            out = new BufferedWriter(new FileWriter("bookstore.txt"));
            for (Element bookEL : bookElList) {
                String category = bookEL.attributeValue("category");
                final Element titleEl = bookEL.element("title");
                final String lang = titleEl.attributeValue("lang");
                final String title = titleEl.getText();
                final String authro = bookEL.elementText("author");
                final String year = bookEL.elementText("year");
                final double price = Double.parseDouble(bookEL.elementText("price"));
                out.write(objectMapper.writeValueAsString(new Book(title, lang, authro, year
                        , price, category)));
                out.newLine();
                out.flush();
            }
        }finally {
            if(out != null){
                out.close();
            }
        }
    }

    public void txt2xml() throws IOException {
        Document document = DocumentHelper. createDocument();
        final Element root = document.addElement("bookstore");
        //stream
        Files.newBufferedReader(Path.of("bookstore.txt")).lines().forEach(s -> {
            try {
                final Book book = objectMapper.readValue(s, Book.class);
                final Element bookEl = root.addElement("book");
                bookEl.addAttribute("category", book.getCategory());
                final Element titleEl = bookEl.addElement("title");
                titleEl.addAttribute("lang", book.getLang());
                titleEl.setText(book.getTitle());
                bookEl.addElement("author").setText(book.getAuthor());
                bookEl.addElement("year").setText(book.getYear());
                bookEl.addElement("price").setText(book.getPrice()+"");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        FileWriter fw = new FileWriter("bookstore3.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(fw,format);
        writer.write(document);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        final EpicTask epicTask = new EpicTask();
        epicTask.xml2txt();
//        epicTask.txt2xml();
    }
}
