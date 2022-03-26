package example.box;

import java.util.ArrayList;

public class Box<T> {
    private ArrayList<T> list = new ArrayList<T>();

    public void add(T item) { 
        list.add(item); 
    }

    public T get(int index) { 
        return list.get(index); 
    }

    public ArrayList<T> getList() {
        return list;
    }

    public int size() { 
        return list.size(); 
    }

    public String toString() {
        return list.toString();
    }
}
