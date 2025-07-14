package hexlet.code.schemas.rules.string;

import hexlet.code.schemas.rules.ValidationRule;

public final class ContainsRule implements ValidationRule<String> {
    private String substring;

    public ContainsRule(String input) {
        this.substring = input;
    }

    public boolean isValid(String value) {
        return value.contains(substring);
    }
}
