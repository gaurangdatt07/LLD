package inMemoryDatabase.model;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String,Table> tables;

    public Database() {
        this.tables=new HashMap<>();
    }

    // create()
    public void createTable(String name){
        tables.put(name, new Table(name));
        System.out.println("Table " + name + " created.");
    }
    // delete()
    public void deleteTable(String tableName){
        tables.remove(tableName);
    }
    // get()
    public Table getTable(String tableName){
        return tables.get(tableName);
    }
}
