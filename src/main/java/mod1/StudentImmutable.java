package mod1;

public final class StudentImmutable {
    private  final String nameImut ;
    private  final Integer ageImut ;



    public StudentImmutable(String nameImut, Integer ageImut) {
        this.nameImut = nameImut;
        this.ageImut = ageImut;
    }

    public  Human human ;

    public static void main(String[] args) {

        Human.age = 25; // можно переприсвоить значения не иммутабельному классу
        StudentImmutable student = new StudentImmutable("Alex", Human.age);
        System.out.println(student);
        System.out.println(Human.age);
        Human.age = 38;
        System.out.println(Human.age);

    }
    @Override
    public String toString() {
        return "StudentImmutable{" +
                "ageImut=" + ageImut +
                ", nameImut='" + nameImut + '\'' +
                '}';
    }
}
