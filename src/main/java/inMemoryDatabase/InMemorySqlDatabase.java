package inMemoryDatabase;

import inMemoryDatabase.interfaceImplementations.MaxLengthConstraint;
import inMemoryDatabase.interfaceImplementations.MinValueConstraint;
import inMemoryDatabase.enums.ColumnType;
import inMemoryDatabase.model.Column;
import inMemoryDatabase.model.Database;
import inMemoryDatabase.model.Table;

import java.util.HashMap;
import java.util.Map;

public class InMemorySqlDatabase {

    public static void main(String[] args) {
        try {
            // Initialize database
            Database db = new Database();

            // Create a table
            db.createTable("Users");
            Table usersTable = db.getTable("Users");

            // Define columns with constraints
            Column nameColumn = new Column("Name", ColumnType.STRING, true);
            nameColumn.addConstraint(new MaxLengthConstraint(20));

            Column ageColumn = new Column("Age", ColumnType.STRING, true);
            ageColumn.addConstraint(new MinValueConstraint(1024));

            usersTable.getColumns().add(nameColumn);
            usersTable.getColumns().add(ageColumn);

            // Insert records
            Map<String, Object> record1 = new HashMap<>();
            record1.put("Name", "John Doe");
            record1.put("Age", 1500);
            usersTable.insertRecord(record1);

            Map<String, Object> record2 = new HashMap<>();
            record2.put("Name", "Jane Smith");
            record2.put("Age", 2000);
            usersTable.insertRecord(record2);

            // Print all records
            System.out.println("All Records:");
            usersTable.printRecords();

            // Filter and print records
            System.out.println("Records where Name is 'John Doe':");
            usersTable.printFilteredRecords("Name", "John Doe");
            usersTable.printFilteredRecords("Name", null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
