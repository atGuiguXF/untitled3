package abstract_;

abstract public class Employee {
    private String name;
    private int id;
    private Double salary;

    //将父类的work()方法做成一个抽象方法
    public abstract void work();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee(String name, int id, Double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}
