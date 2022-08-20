package interface_;

public class Interfa02 {
    public static void main(String[] args) {

    }
}
//如果一个类 implements实现一个接口
//需要将该接口的所有抽象方法都实现
class A implements AInterface{
    @Override
    public void hi() {
        System.out.println("hi()...");
    }
}