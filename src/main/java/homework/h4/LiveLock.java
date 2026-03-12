package homework.h4;

public class LiveLock {
    static class Person{
        private String name;
        private boolean walk;

        public Person(String name) {
            this.name = name;
            this.walk = true;
        }
        public void walk(Person person){
            while (walk){
                if (person.walk){
                    door(person);
                } else {
                    System.out.println(name + " прошел");
                    walk = false;
                }
            }
        }

        private void door(Person secondPerson) {
            System.out.println(name + " встретил у двери " + secondPerson.name + " уступаю");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println(name + " Проверяю можно ли пройти");
        }
    }

    public static void main(String[] args) {
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");
        new Thread(()-> alice.walk(bob), "Alice" ).start();
        new Thread(()-> bob.walk(alice), "Bob").start();
    }
}
