package hexlet.code.schemas.rules.string;

import hexlet.code.schemas.rules.ValidationRule;

public final class MinLengthRule implements ValidationRule<String> {
    private int minLength;

    public MinLengthRule(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("Minimal length cannot be negative");
        }

        this.minLength = input;
    }

    public boolean isValid(String value) {
        return value.length() >= minLength;
    }
}
