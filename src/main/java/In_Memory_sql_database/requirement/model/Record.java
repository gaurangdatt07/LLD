package In_Memory_sql_database.requirement.model;

import java.util.List;

public class Record {
    private List<Object> values;

    public List<Object> getValues() {
        return values;
    }

    public Record(List<Object> values) {
        this.values = values;
    }
}
