package ex.ex04;

public class Manager extends Employee{
    //特有属性
    private double bonus;//奖金

    //创建Manager对象时 奖金多少并不是确定的
    //可以通过setBonus
    public Manager(String name, double daySal, int workDays, double grade) {
        super(name, daySal, workDays, grade);
    }
    //方法 重写父类的printSal

    @Override
    public void printSal() {
        //因为经理的工资计算方式和Employee不一样 所以重写
        System.out.println(" 经理 "+ getName()+" 工资是="+
                (bonus+getDaySal()*getWorkDays()*getGrade()));
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
