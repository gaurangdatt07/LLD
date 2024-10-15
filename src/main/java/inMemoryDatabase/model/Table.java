package inMemoryDatabase.model;

import inMemoryDatabase.enums.ColumnType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table {
    private String name;
    private List<Record>records;
    private List<Column>columns;

    public Table(String name) {
        this.name = name;
        this.columns=new ArrayList<>();
        this.records=new ArrayList<>();
    }

    // add column or update
    public void addColumn(String columnName, ColumnType columnType, boolean isRequired){
        this.columns.add(new Column(columnName,columnType,isRequired));
    }

    // insert Record
    public void insertRecord(Map<String,Object> values) throws Exception {
        Record record = new Record();
        for (Column column : columns) {
            Object value = values.get(column.getName());
            if (!column.validate(value)) {
                throw new Exception("Validation failed for column: " + column.getName());
            }
            record.addValue(column.getName(), value);
        }
        records.add(record);
    }

    // print all record
    public void printRecords(){
        for(Record record:records){
            System.out.println(record);
        }
    }
    // print filtered record
    public void printFilteredRecords(String columnName,Object value){
        for (Record record : records) {
            Object columnValue = record.getValue(columnName);

            // If column value is null, skip this record
            if (columnValue == null) continue;

            // If a non-null value is provided, print only matching records
            if (columnValue.equals(value)) {
                System.out.println(record);
            }
            // If the value is null, print all non-null column value records
            else if (value == null) {
                System.out.println(record);
            }
        }
    }

    public List<Column> getColumns() {
        return columns;
    }
}
