package interface_;
/**
 * 当子类继承了父类 就自动拥有父类的功能
 * 如果子类需要扩展功能 可以通过实现接口的方式来扩展
 * 可以理解 实现接口 是对java单继承机制的一种补充
 *
 * 继承的价值主要在于 解决代码的复用性和可维护性
 * 接口的价值主要在于 设计号各种规范(方法) 让其他类去实现这些方法
 * 接口比继承更加灵活
 * 继承不能滥用 满足 is - a的关系 而接口只需满足 like - a的关系
 * 接口在一定程度上实现代码解耦 [即 接口规范性 + 动态绑定机制]
 * */
public class ExtendsVsInterface {
    public static void main(String[] args) {
        final LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}
class Monkey{
    private String name;

    public String getName() {
        return name;
    }

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing(){
        System.out.println(name+"会爬树...");
    };
}
interface FishAble{
    void swimming();
}
interface BirdAble{
    void flying();
}
//LittleMonkey 继承了 父类Monkey
class LittleMonkey extends Monkey implements FishAble,BirdAble{

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "通过学习可以像鱼一样游泳");
    }

    @Override
    public void flying() {
        System.out.println(getName()+"通过学习可以像鸟一样飞翔");
    }
}