package hexlet.code.schemas.rules.map;

import hexlet.code.schemas.rules.ValidationRule;
import java.util.Map;

public final class SizeRule implements ValidationRule<Map<?, ?>> {
    private int size;

    public SizeRule(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("The map size cannot be negative");
        }

        this.size = input;
    }

    public boolean isValid(Map<?, ?> value) {
        if (value == null) {
            return true;
        }

        return value.size() == size;
    }
}
