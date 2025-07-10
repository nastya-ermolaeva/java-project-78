package hexlet.code.schemas.rules.string;

import hexlet.code.schemas.rules.ValidationRule;

public class ContainsRule implements ValidationRule<String> {
    private String substring;

    public ContainsRule(String substring) {
        this.substring = substring;
    }

    public boolean isValid(String value) {
        return value.contains(substring);
    }
}
