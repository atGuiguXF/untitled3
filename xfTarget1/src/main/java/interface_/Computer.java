package interface_;

public class Computer {
    //编写一个方法 电脑工作
    //1.UsbInterface usbInterface 形参是接口类型 UsbInterface
    //2.看到 接受 实现了 UsbInterface接口的类的对象实例
    public void work(UsbInterface usbInterface){
        //通过接口来调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}
