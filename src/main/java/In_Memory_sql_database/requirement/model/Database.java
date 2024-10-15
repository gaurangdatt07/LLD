package In_Memory_sql_database.requirement.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private String databaseName;
    private Map<String,Table> tableMap;


    public Database(String databaseName) {
        this.databaseName = databaseName;
        this.tableMap=new HashMap<>();
    }

    public void createOrUpdate(String tableName, List<Column> columnList){
        if(tableMap.containsKey(tableName)){
            //updateTable(tableName,columnList);
        }else{
            tableMap.put(tableName,new Table(tableName,columnList));
        }
    }

    public void deleteTable(String tableName){
            tableMap.remove(tableName);
    }

    public Table getTable(String tableName){
        return tableMap.get(tableName);

    }
}
