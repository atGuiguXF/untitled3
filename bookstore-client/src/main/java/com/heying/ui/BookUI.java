package com.heying.ui;

import com.heying.entity.Book;
import com.heying.net.NetClient;
import com.heying.net.NetMsg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookUI {

    private ClientUI clientUI;

    private Scanner in = new Scanner(System.in);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public BookUI(ClientUI clientUI) throws Exception {
        this.clientUI = clientUI;
        mainWindow();
    }

    public void mainWindow() throws Exception {
        System.out.println("请选择:1.查询图书 2.添加图书 3.修改图书 4.删除图书 0.返回上一级菜单");
        int select = in.nextInt();
//        final ClientUI clientUI = new ClientUI();//新建一个clientUI调用其方法
        switch (select) {
            case 1://查询图书
                queryWindow();
                break;
            case 2://添加图书
                addWindow();
                break;
            case 3://修改图书
                alterWindow();
                break;
            case 4:
                deleteWindow();
                break;
            case 0:
                clientUI.mainWindow();
                break;
        }
    }

    public void deleteWindow()  {
        System.out.println("请输入要删除的图书ISBN");
        String isbn = in.next();
        final NetClient netClient = NetClient.getInstance();
        final Book book = new Book();
        book.setIsbn(isbn);
        try {
            final NetMsg response = netClient.send(new NetMsg(book, "BOOK_DELETE"));
//            System.out.println(response.getData());
            if (response.getType().equals("SUCCESS")) {
                System.out.println(response.getData());
                mainWindow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void alterWindow() {//修改图书method
        System.out.println("请输入要修改图书的ISBN：");
        String isbn = in.next();//用户输入
        final NetClient netClient = NetClient.getInstance();
        final Book book = new Book();
        book.setIsbn(isbn);

        try {
            final NetMsg response = netClient.send(new NetMsg(book, "BOOK_QUERY"));
            System.out.println(response.getData());
            if (response.getType().equals("SUCCESS")) {
                System.out.println("请选择修改内容 1.成本和售价 2.图书名 3.出版社ID 4.出版日期" +
                        "5.修改种类");
                int select = in.nextInt();
                switch (select) {
                    case 1:
                        System.out.println("请输入修改后的成本");
                        double cost = in.nextDouble();
                        System.out.println("请输入修改后的售价");
                        double retail = in.nextDouble();
                        final Book bookCost = new Book();
                        bookCost.setIsbn(isbn);
                        bookCost.setCost(cost);
                        bookCost.setRetail(retail);
                        final NetMsg book_alter = netClient.send(new NetMsg(bookCost, "BOOK_ALTER"));
                        if (book_alter.getType().equals("SUCCESS")) {
                            System.out.println(book_alter.getData());
                            mainWindow();
                        }
                        break;
                    case 2:
                        System.out.println("请输入修改后的图书书名");
                        String title = in.next();
                        final Book bookTitle = new Book();
                        bookTitle.setIsbn(isbn);
                        bookTitle.setTitle(title);
                        final NetMsg book_alter1 = netClient.send(new NetMsg(bookTitle, "BOOK_ALTER"));
                        if (book_alter1.getType().equals("SUCCESS")) {
                            System.out.println(book_alter1.getData());
                            mainWindow();
                        }
                        break;
                    case 3:
                        System.out.println("请输入修改后的出版社ID");
                        int bookId = in.nextInt();
                        final Book puBid = new Book();
                        puBid.setIsbn(isbn);
                        puBid.setPubid(bookId);
                        final NetMsg book_alter2 = netClient.send(new NetMsg(puBid, "BOOK_ALTER"));
                        if (book_alter2.getType().equals("SUCCESS")) {
                            System.out.println(book_alter2.getData());
                            mainWindow();
                        }
                    case 4:
                        System.out.println("请输入修改后的出版日期 yyyy-MM-dd");
                        String bookDate = in.next();
                        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        final Date bookdate = format.parse(bookDate);
                        final Book date = new Book();
                        date.setIsbn(isbn);
                        date.setPubdate(bookdate);
                        final NetMsg book_alter3 = netClient.send(new NetMsg(date, "BOOK_ALTER"));
                        if (book_alter3.getType().equals("SUCCESS")) {
                            System.out.println(book_alter3.getData());
                            mainWindow();
                        }
                    case 5:
                        System.out.println("请输入修改后的种类");
                        String category = in.next();
                        final Book bookCategory = new Book();
                        bookCategory.setIsbn(isbn);
                        bookCategory.setCategory(category);
                        final NetMsg book_alter4 = netClient.send(new NetMsg(bookCategory, "BOOK_ALTER"));
                        if (book_alter4.getType().equals("SUCCESS")) {
                            System.out.println(book_alter4.getData());
                            mainWindow();
                        }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addWindow() throws Exception {//添加图书method
        System.out.println("请输入ISBN:");
        String isbn = in.next();
        System.out.println("请输入书名:");
        String title = in.next();
        System.out.println("请输入出版日期(yyyy-MM-dd):");
        String pubdateStr = in.next();
        try {
            Date pubdate = simpleDateFormat.parse(pubdateStr);
            System.out.println("请输入出版社ID:");
            int pubid = in.nextInt();
            System.out.println("请输入成本:");
            double cost = in.nextDouble();
            System.out.println("请输入售价:");
            final double retail = in.nextDouble();
            System.out.println("请输入种类:");
            String category = in.next();

            final Book book = new Book(isbn, title, pubdate, pubid, cost
                    , retail, category);
            final NetClient netClient = NetClient.getInstance();
            final NetMsg response = netClient.send(new NetMsg(book, "BOOK_ADD"));
            if (response.getType().equals("SUCCESS")) {
                System.out.println(response.getData());
                mainWindow();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统异常");
            mainWindow();
        }
    }

    public void queryWindow() {//查询图书method
        System.out.println("请选择查询条件:1.ISBN 2.书名 3.种类 0.所有图书");
        int select = in.nextInt();
        final NetClient netClient = NetClient.getInstance();
        final Book book = new Book();
        switch (select) {
            case 1:
                System.out.println("请输入ISBN:");
                String isbn = in.next();
                book.setIsbn(isbn);
                break;
            case 2:
                System.out.println("请输入书名:");
                String title = in.next();
                book.setTitle(title);
                break;
            case 3:
                System.out.println("请输入种类：");
                String category = in.next();
                book.setCategory(category);
                break;
            case 0:
                book.toString();
        }
        try {
            final NetMsg<List<Book>> response = netClient.send(new NetMsg(book, "BOOK_QUERY"));
//                    System.out.println(response);
            if (response.getType().equals("SUCCESS")) {
                printBook(response.getData());
            }
            mainWindow();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统异常");
            queryWindow();
        }
    }

    private void printBook(List<Book> list) {
        System.out.println("ISBN\t\t书名\t\t出版日期\t\t出版社\t\t成本\t\t售价\t\t种类");
        list.forEach(b -> System.out.println(b.getIsbn() + "\t\t" +
                b.getTitle() + "\t\t" + b.getPubdate() + "\t\t" + b.getPubid() + "\t\t" +
                b.getCost() + "\t\t" + b.getRetail() + "\t\t" + b.getCategory()));
    }
}
