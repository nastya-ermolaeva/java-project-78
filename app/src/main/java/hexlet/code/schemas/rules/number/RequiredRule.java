package hexlet.code.schemas.rules.number;

import hexlet.code.schemas.rules.ValidationRule;

public final class RequiredRule implements ValidationRule<Integer> {
    public boolean isValid(Integer value) {
        return value != null;
    }
}
