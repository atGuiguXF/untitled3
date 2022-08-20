package InnerClass;

/**
 * 局部内部类的使用
 * */

/**
 * 局部内部类是定义在外部类的局部位置 比如方法中并且有类名
 * 1.可以直接访问外部类的所有成员 包含私有的
 * 2.不能添加访问修饰符 因为它的地位就是一个局部变量 局部变量是不能使用修饰符的
 * 但是可以使用final修饰 因为局部变量也可以使用final
 * 3.作用域：仅仅在定义它的方法或代码块中
 * 4.局部内部类---访问---》外部类的成员  [访问方式：直接访问]
 * 5.外部类---访问--》局部内部类的成员
 * 访问方式：创建对象 再访问  ！必须在作用域内
 * */
public class LocalInnerClass {
    public static void main(String[] args) {
//跑一把
        final Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}
class Outer02{//外部类
    private int n1 =100;//属性
    private void m2(){
        System.out.println("Outer02 m2()");
    }//私有方法
    public void m1(){//方法
        //1.局部内部类是定义在外部类的局部位置 通常在方法
        //3.能添加访问修饰符 但是可以使用final修饰
        //4.作用域：仅仅在定义它的方法或代码块中
   final   class Inner02{//局部内部类 (本质仍然是一个类)
            //2.可以直接访问外部类的所有成员 包含私有的
            public void f1(){
                //5.局部内部类可以直接访问外部类的成员 比如下面
                System.out.println("n1 = "+n1);
                m2();
            }
        }
        //外部类在方法中 可以创建Inner02对象实例 然后调用方法即可
        final Inner02 inner02 = new Inner02();
        inner02.f1();
    }
     }
