package inMemoryDatabase.interfaceImplementations;

public class MaxLengthConstraint implements Constraint {
    private int maxLength;

    public MaxLengthConstraint(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean validate(Object value) {
        if(value instanceof String){
            return ((String)value).length()<maxLength;
        }
        return false;
    }
}
