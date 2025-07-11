package hexlet.code.schemas.rules.string;

import hexlet.code.schemas.rules.ValidationRule;

public class MinLengthRule implements ValidationRule<String> {
    private int minLength;

    public MinLengthRule(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Minimal length cannot be negative");
        }

        this.minLength = minLength;
    }

    public boolean isValid(String value) {
        return value.length() >= minLength;
    }
}
