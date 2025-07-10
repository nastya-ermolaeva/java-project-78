package hexlet.code.schemas.rules.number;

import hexlet.code.schemas.rules.ValidationRule;

public class RangeRule implements ValidationRule<Integer> {
    private int begin;
    private int end;

    public RangeRule(int begin, int end) {
        if (begin > end) {
            throw new IllegalArgumentException("Incorrect range: the beginning is greater than the end");
        }

        this.begin = begin;
        this.end = end;
    }

    public boolean isValid(Integer value) {
        if (value == null) {
            return true;
        }

        return value >= begin && value <= end;
    }
}
