package In_Memory_sql_database.requirement.model;

import java.util.Objects;

public class Column {
    private String name;
    private DataType type;
    private boolean isMandatory;
    private Constraint constraint;


    public Column(String name, DataType type, boolean isMandatory, Constraint constraint) {
        this.name = name;
        this.type = type;
        this.isMandatory = isMandatory;
        this.constraint = constraint;
    }


    public boolean validate(Record record){
        if(isMandatory&& Objects.isNull(record)){
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }
}
