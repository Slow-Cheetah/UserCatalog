package com.example.usercatalog;

public class User {
    private String name;
    private String age;

    @Override
    public String toString() {
        return "Пользователь: \n" +
                "Имя - " + name + '.' +
                " Возраст - " + age + '.';
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
