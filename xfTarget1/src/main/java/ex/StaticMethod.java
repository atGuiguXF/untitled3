package ex;

public class StaticMethod {
    public static void main(String[] args) {
        //创建俩个学生对象 交学费
        final Stu tom = new Stu("Tom");
//        tom.payFee(100);
        Stu.payFee(100);

        final Stu mary = new Stu("Mary");
//        mary.payFee(200);
        Stu.payFee(200);
        //输出当前收到的总学费
        
        Stu.showFee();
    }
}
class Stu{
    private String name;//普通成员
    //定义一个静态变量 累计学生学费
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    //当方法使用了static修饰后 该方法就是静态方法
    //静态方法就可以访问静态属性/静态变量
    public static void payFee(double fee){
        Stu.fee += fee;//累积到
    }
    public static void showFee(){
        System.out.println("总学费有：" +Stu.fee);
    }
}
