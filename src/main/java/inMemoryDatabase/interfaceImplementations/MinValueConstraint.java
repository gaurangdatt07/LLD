package inMemoryDatabase.interfaceImplementations;

public class MinValueConstraint implements Constraint {

    private int minValue;

    public MinValueConstraint(int minLength) {
        this.minValue = minLength;
    }

    @Override
    public boolean validate(Object value) {
        if(value instanceof Integer){
            return ((Integer)value)>= minValue;
        }
        return false;
    }
}
