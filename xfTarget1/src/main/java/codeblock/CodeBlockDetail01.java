package codeblock;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        //类加载的情况举例
        //1.创建对象实例时(new)
//        final AA aa = new AA();
        //2.创建子类对象实例 父类也会被加载 而且父类先被加载 随后子类
        //继承的本质 先加载父类再加载子类
//        final AA aa2 = new AA();
        //3.使用类的静态成员(静态属性，静态方法)
//        System.out.println(Cat.n1);
        //static代码块 是在类加载时 执行的 而且只会执行一次
//        final DD dd = new DD();
//        final DD dd1 = new DD();
        System.out.println(DD.n1);
    }
}
class DD{
    public static int n1 = 8888;//静态属性
    //静态代码块
    static {
        System.out.println("DD 类的静态代码块被执行");
    }
    //普通代码块  在 new 对象时 被调用  而且每创建一个对象就调用一次
    //普通代码块是构造器的补充
    {
        System.out.println("DD类的普通代码块");
    }
}
class Animal{
    //静态代码块
    static {
        System.out.println("Animal 类的静态代码块被执行");
    }
}
class Cat extends Animal{
    public static int n1 = 999;
    static {
        System.out.println("Cat类的静态代码块被执行");
    }
}
class BB{
    //静态代码块
    static{
        System.out.println("BB的静态代码块被执行");
    };
}
class AA extends BB{
    //静态代码块
    static{
        System.out.println("AA的静态代码块被执行");
    };
}
