package userdb;

public class User {
    public String name;
    public int age;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "[name : " + this.name + ", age : " + this.age + "]";
    }
}
