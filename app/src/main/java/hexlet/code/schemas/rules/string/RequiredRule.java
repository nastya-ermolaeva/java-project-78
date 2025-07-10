package hexlet.code.schemas.rules.string;

import hexlet.code.schemas.rules.ValidationRule;

public class RequiredRule implements ValidationRule<String> {
    public boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }
}
