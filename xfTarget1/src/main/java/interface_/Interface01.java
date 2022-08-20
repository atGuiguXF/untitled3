package interface_;

public class Interface01 {
    public static void main(String[] args) {
        //创建手机 相机对象
        Camera camera = new Camera();
        Phone phone = new Phone();
        //创建计算机
        final Computer computer = new Computer();
        computer.work(phone);//把手机接入电脑
        System.out.println("=========");
        computer.work(camera);//把相机接入到电脑
    }
}
