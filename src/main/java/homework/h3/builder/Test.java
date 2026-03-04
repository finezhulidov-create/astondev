package homework.h3.builder;

public class Test {
    public static void main(String[] args) {
        User user = new User.Builder()
                .id(88888)
                .name("Yasha")
                .country("Kenya")
                .build();
        System.out.println(user);
        System.out.println(user.getCountry());
        System.out.println(user.getId());
        System.out.println(user.getName());

    }
}
