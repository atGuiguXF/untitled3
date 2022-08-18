package single_;

public class SingleTon01 {
    public static void main(String[] args) {
//  GirlFriend xh = new GirlFriend("小红");
//  GirlFriend xb = new GirlFriend("小白");
        //通过方法可以获取对象
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);
//        System.out.println(GirlFriend.n1);
    }

}
//有一个类 GirlFriend
//只能有一个女朋友
class GirlFriend{
    private String name;
//    public static int n1= 100;
    //为了能够在静态方法中 返回gf对象 需要将其修饰为static
    //对象 通常是重量级的对象 饿汉式可能造成资源浪费 创建了对象但是没有使用
    private static GirlFriend gf = new GirlFriend("小芳");
    //如何保障我们只能创建一个 GirlFriend对象
    //步骤：[单例模式-饿汉式]
    //1 将构造器私有化
    //2 在类的内部直接创建
    //3 提供一个公共的 static 方法  返回 gf对象
    private GirlFriend(String name) {
        System.out.println("构造器被调用.");
        this.name = name;
    }
    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
