package homework.h1;

public class Human {
    private String name;
    private Integer age;

    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
       this.age = age;
    }

    public void showNameAndAge(){
        System.out.println(this.name +" "+ this.age );
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Human copy() {
        return new Human(this.name,this.age);
    }
}
