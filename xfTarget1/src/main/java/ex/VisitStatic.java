package ex;

public class VisitStatic {
    public static void main(String[] args) {


        //类名.类变量名
        //静态变量是随着类的加载而创建，所以没有创建对象实例也可以访问
        System.out.println(A.name);
        A a = new A();
        System.out.println(A.name);
    }
}

class A{
    //类变量(静态变量)
    //类变量的访问 必须遵守相关访问权限
    public static String name = "徐峰";
    //普通属性(普通成员变量/非静态变量/非静态成员变量/实例变量)
    private int num = 10;
}