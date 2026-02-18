package homework.h1;

public class Human {
    public static String name;
    public   static Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
       this.age = age;
    }

    public void showNameAndAge(){
        System.out.println(this.name +" "+ this.age );
    }

    public String getName(String name){
      return   this.name = name;
    }

    public Integer getAge(Integer age){
        return this.age = age;
    }


}
