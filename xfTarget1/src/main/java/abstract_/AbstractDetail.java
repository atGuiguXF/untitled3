package abstract_;

public class AbstractDetail {
    public static void main(String[] args) {
    //抽象类不能被实例化
    //    new A();
    }
}
//抽象类不一定要包含abstract()方法 也就是说 抽象类可以没有abstract()方法
//还可以有实现的方法
abstract class A{
        public void hi(){};
}
//一个类包含了abstract()方法 则这个类必须声明为abstract类
abstract class B{
    public abstract void hi();
}
//abstract只能修饰类和方法 不能修饰属性和其他的
class C{
//    public abstract int n1 = 1;
}
