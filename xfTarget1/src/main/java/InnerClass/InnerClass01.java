package InnerClass;

/**
 *  内部类
 *  一个类的内部又完整的嵌套了另一个类结构。被嵌套的类称为内部类(inner class)
 *  嵌套其他类的类称为外部类(outer class)。是我们类的五大成员(属性、方法
 *  构造器、代码块、内部类)        内部类最大的特点就是可以直接房屋内私有属性
 *  并且 可以体现类与类之间的包含关系
 * */
public class InnerClass01 {//外部其他类
    public static void main(String[] args) {

    }
}
class Outer{//外部类
    private int n1 = 100;//属性
    public void m1(){//方法
        System.out.println("m1()");
    }
    {//代码块
        System.out.println("代码块");
    }

    public Outer(int n1) {//构造器
        this.n1 = n1;
    }
    class Inner{//内部类 在Outer类的内部

    }
}
