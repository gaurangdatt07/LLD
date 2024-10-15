package In_Memory_sql_database.requirement.model;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String tableName;
    private List<Column> columns;
    private List<Record> records;
    private boolean isDeleted;

    public Table(String tableName, List<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
        this.records=new ArrayList<>();
    }

    //insert record
    public void insertRecord(Record record){
        validate(record);
        records.add(record);
    }

    private void validate(Record record) {

    }

    // print record
    public void printRecords(){
        for(Record record:records){
            System.out.println(record);
        }
    }

    // printFilteredRecords
    public void printFilteredRecord(String columnName){
        int index=getColumnIndexByName(columnName);
        if(index==-1){
            System.out.println("no such column found");
        }
        for(Record record:records){
            System.out.println(record.getValues().get(index));
        }
    }

    private int getColumnIndexByName(String columnName) {
        for(int i = 0 ; i <columns.size();i++){
            if(columns.get(i).getName().equals(columnName)){
                return i;
            }
        }
        return -1;
    }
}
