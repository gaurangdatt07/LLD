package inMemoryDatabase.model;

import java.util.HashMap;
import java.util.Map;

public class Record {
    private Map<String,Object> value;

    public Record() {
        this.value =new HashMap<>();
    }

    public void addValue(String columnName,Object value){
        this.value.put(columnName,value);
    }

    public Object getValue(String columnName) {
        return value.get(columnName);
    }

    @Override
    public String toString() {
        return "Record{" +
                "value=" + value +
                '}';
    }
}
