package abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        //测试
        final Manager jack = new Manager("jack", 999, 50000.0);
        jack.setBonus(8000);
        jack.work();

        final CommonEmployee tom = new CommonEmployee("tom", 888, 20000.0);
        tom.work();
    }
}
