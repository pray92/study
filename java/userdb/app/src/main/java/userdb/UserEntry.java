package userdb;

public class UserEntry extends Entry<User> {
    
    public UserEntry(String key, User user) {
        this.key = key;
        this.value = user; 
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
