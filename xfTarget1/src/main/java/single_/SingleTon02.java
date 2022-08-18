package single_;

/**
 * 懒汉式的单例模式
 *
 * 饿汉式VS懒汉式
 * 1 二者的主要区别在于创建对象的时机不同 饿汉式是在类加载就创建了对象实例
 *   而懒汉式是在使用时才创建。
 * 2 饿汉式不存在线程安全问题 懒汉式存在线程安全问题
 * 3 饿汉式存在浪费资源的可能 因为如果程序员一个对象实例都没有使用
 *   那么饿汉式创建的对象就浪费了 懒汉式是使用时才创建 就不存这个问题
 */
public class SingleTon02 {
    public static void main(String[] args) {
//        new Cat("大黄");
//        System.out.println(Cat.n1);
        final Cat instance = Cat.getInstance();
        System.out.println(instance);

        //再次调用getInstance
        final Cat instance1 = Cat.getInstance();
        System.out.println(instance1);

        System.out.println(instance == instance1);
    }
}

//希望在程序运行过程中只能创建一个Cat对象
//使用单例模式
class Cat {
    private String name;
    public static int n1 = 999;
    private static Cat cat;//默认是null

    //步骤
    //1 构造器私有化
    //2 定义一个static静态属性对象
    //3 提供一个public的static方法 可以返回一个Cat对象
    //4 懒汉式，只有当用户使用getInstance() 才返回cat对象 后面再次调用时 会返回上次创建的cat对象
    //从而保证了单例
    private Cat(String name) {
        System.out.println("构造器调用");
        this.name = name;
    }

    public static Cat getInstance() {

        if (cat == null) {//如果还没有创建cat 对象
            cat = new Cat("小可爱");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
