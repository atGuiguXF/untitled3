package abstract_;

public class BB extends Template{
    @Override
    public void job() {//这里也去 重写了Template的job()方法
        long num = 0;
        for (long i = 1; i <= 80000; i++) {
            num *= i;
        }
    }
}
