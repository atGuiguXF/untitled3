package interface_;

public interface AInterface {
    //写属性
    public int n1 = 10;
    //写方法(1抽象方法 2默认实现方法 3静态方法)
    //在接口中 抽象方法可以省略 abstract
    public void hi();
    //在jdk8后 可以有默认实现方法 需要使用default关键字修饰
    default void ok(){
        System.out.println("ok()...");
    }
    //jdk8后 可以有静态方法
    public static void cry(){
        System.out.println("cry()...");
    }
}
