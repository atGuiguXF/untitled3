package final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        final CC cc = new CC();
        new EE().cal();
    }
}

class AA {
    /*
        定义时 如 public final double TAX_RATE=0.08;
        在构造器中
        在代码块中
     */
    public final double TAX_RATE = 0.08;//定义时赋值
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    public AA() {
        TAX_RATE2 = 1.1;
    }
    {
        TAX_RATE3 = 8.8;
    }
}
class BB{
    /*
    如果final修饰的属性是静态的 则初始化的位置只能是
    1.在定义时
    2.在静态代码块中 不能在构造器中赋值
     */
    public final static double TAX_RATE = 6.6;
    public final static double TAX_RATE2;
    static {
        TAX_RATE2 = 99.9;
    }
}
//final类不能继承 但可以实例化
final class CC{
}//如果类不是final类 但含有final方法 则该方法虽然不能重写 但是可以被继承
class DD{
        public final void cal(){
            System.out.println("cal()方法");
        }
}
class EE extends DD{
}
