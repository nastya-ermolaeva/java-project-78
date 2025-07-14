package hexlet.code.schemas.rules.number;

import hexlet.code.schemas.rules.ValidationRule;

public final class RangeRule implements ValidationRule<Integer> {
    private int begin;
    private int end;

    public RangeRule(int inputBegin, int inputEnd) {
        if (inputBegin > inputEnd) {
            throw new IllegalArgumentException("Incorrect range: the beginning is greater than the end");
        }

        this.begin = inputBegin;
        this.end = inputEnd;
    }

    public boolean isValid(Integer value) {
        if (value == null) {
            return true;
        }

        return value >= begin && value <= end;
    }
}
