package hexlet.code.schemas.rules.number;

import hexlet.code.schemas.rules.ValidationRule;

public class RequiredRule implements ValidationRule<Integer> {
    public boolean isValid(Integer value) {
        return value != null;
    }
}
