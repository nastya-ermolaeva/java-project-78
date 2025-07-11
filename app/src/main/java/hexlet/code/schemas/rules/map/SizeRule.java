package hexlet.code.schemas.rules.map;

import hexlet.code.schemas.rules.ValidationRule;
import java.util.Map;

public class SizeRule implements ValidationRule<Map<?, ?>> {
    private int size;

    public SizeRule(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("The map size cannot be negative");
        }

        this.size = size;
    }

    public boolean isValid(Map<?, ?> value) {
        if (value == null) {
            return true;
        }

        return value.size() == size;
    }
}
