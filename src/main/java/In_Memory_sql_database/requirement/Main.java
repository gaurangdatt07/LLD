package In_Memory_sql_database.requirement;

import In_Memory_sql_database.requirement.model.*;
import In_Memory_sql_database.requirement.model.Record;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Database db = new Database("gaurang");
        // Create a table
        List<Column> columns = Arrays.asList(
                new Column("id", DataType.NUMBER, true, new Constraint.IntMinValueConstraint(1024)),
                new Column("name", DataType.STRING, true, new Constraint.StringLengthConstraint(20))
        );

        db.createOrUpdate("Users",columns);

        // Insert records
        db.getTable("Users").insertRecord(new In_Memory_sql_database.requirement.model.Record(Arrays.asList(1025, "John")));
        db.getTable("Users").insertRecord(new Record(Arrays.asList(1026, "Jane")));
        db.getTable("Users").insertRecord(new Record(Arrays.asList(1027, "Doe")));

        // Print all records
        System.out.println("All Records:");
        db.getTable("Users").printRecords();


        // Print all records after update
        System.out.println("All Records After Update:");
        db.getTable("Users").printRecords();

        // Filter records
        System.out.println("\nFiltering records where name is Johnny:");
         db.getTable("Users").printFilteredRecord("id");

        // Delete a table
        db.deleteTable("Users");
        System.out.println("\nDeleted Users table.");
    }


}
