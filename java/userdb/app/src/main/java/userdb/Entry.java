package userdb;

public class Entry<T> {
    protected String key;
    public T value;

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
