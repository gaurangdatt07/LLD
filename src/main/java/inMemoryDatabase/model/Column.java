package inMemoryDatabase.model;

import inMemoryDatabase.enums.ColumnType;
import inMemoryDatabase.interfaceImplementations.Constraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Column {
    private String name;
    private ColumnType columnType;
    private boolean isRequired;
    private List<Constraint> constraints;

    public Column(String name, ColumnType columnType, boolean isRequired) {
        this.name = name;
        this.columnType = columnType;
        this.isRequired = isRequired;
        this.constraints = new ArrayList<>();
    }

    public void addConstraint(Constraint constraint){
        this.constraints.add(constraint);
    }

    public boolean validate(Object value){
        if(isRequired&& Objects.isNull(value)) {
            return false;
        }
        for(Constraint constraint:constraints){
            if(!constraint.validate(value)){
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }
}
