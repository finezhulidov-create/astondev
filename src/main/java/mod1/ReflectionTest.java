package mod1;

import java.lang.reflect.Field;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Human human = new Human();

        Class<? extends Human> aClass = human.getClass();
        Field name = aClass.getDeclaredField("name");
        Field age = aClass.getDeclaredField("age");
        name.setAccessible(true);
        name.set(human, "Kolya");
        age.setAccessible(true);
        age.set(human, 23);
        human.showNameAndAge();


    }
}
