package homework.h3.builder;

import java.util.Objects;

public class User {
    private final String name;
    private final Long id;
    private final String country;

    public User(Builder builder) {
        this.id = Objects.requireNonNull(builder.id, "id");
        this.name = Objects.requireNonNull(builder.name, "name");
        this.country = Objects.requireNonNull(builder.country, "country");
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder{
        private String name;
        private Long id;
        private String country;


        public Builder id(long id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder country(String country){
            this.country = country;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", country='" + country + '\'' +
                '}';
    }
}
