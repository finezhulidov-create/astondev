package homework.h1;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Alex", 24);
        StudentImmutable studentImmutable = new StudentImmutable("Math",5, human);

        System.out.println(studentImmutable);

        human.setName("Egor");
        System.out.println("Измененный human: " + human);
        System.out.println("StudentImmutable после изменения: " + studentImmutable);

        Human newHuman = studentImmutable.getHuman();
        newHuman.setAge(28);
        System.out.println("copy: " + newHuman);
        System.out.println(studentImmutable);
    }
}
