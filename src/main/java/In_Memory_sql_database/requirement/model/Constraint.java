package In_Memory_sql_database.requirement.model;

import java.util.Objects;

public interface Constraint {
    boolean isValid(Object value);


    public class StringLengthConstraint implements Constraint {
        private int maxLength;

        public StringLengthConstraint(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public boolean isValid(Object value) {
            if (value instanceof String) {
                return ((String) value).length() <= maxLength;
            }
            return false;
        }
    }

    public class IntMinValueConstraint implements Constraint {
        private int minValue;

        public IntMinValueConstraint(int minValue) {
            this.minValue = minValue;
        }

        @Override
        public boolean isValid(Object value) {
            if (value instanceof Integer) {
                return (Integer) value >= minValue;
            }
            return false;
        }
    }
}
