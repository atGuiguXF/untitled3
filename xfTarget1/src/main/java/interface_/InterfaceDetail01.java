package interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
//        new IA();
    }
}

//接口不能被实例化
//接口中的方法是 public 方法 接口中抽象方法 可以不用abstract修饰
//一个普通类实现接口 就必须将该接口中的所有方法实现 alt + enter快捷键生成
//抽象类实现接口时 可以不实现接口的抽象方法
interface IA {
    public abstract void say();
    void hi();
}
class Cat implements IA{
    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }
}
abstract class Tiger implements IA{}