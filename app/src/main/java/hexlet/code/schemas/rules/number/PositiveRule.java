package hexlet.code.schemas.rules.number;

import hexlet.code.schemas.rules.ValidationRule;

public final class PositiveRule implements ValidationRule<Integer> {
    public boolean isValid(Integer value) {
        if (value == null) {
            return true;
        }

        return value > 0;
    }
}
