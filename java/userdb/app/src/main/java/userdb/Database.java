package userdb;

import java.util.ArrayList;
import java.util.List;

public class Database<T extends Entry<?>> {
    private List<T> list = new ArrayList<T>();

    public T get(String key) {
        for(T entry : list){
            if(entry.key.equals(key)){
                return entry;
            }
        }
        
        return null;
    }

    public void put(T entry){
        list.add(entry);
    }

    public List<T> getAll() {
        return new ArrayList<T>(list);
    }
}
