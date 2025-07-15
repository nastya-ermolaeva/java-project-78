package hexlet.code.schemas;

import java.util.function.Predicate;

public final class ValidationRule<T> {
    private final String name;
    private final Predicate<T> rule;

    public ValidationRule(String ruleName, Predicate<T> ruleLogic) {
        this.name = ruleName;
        this.rule = ruleLogic;
    }

    public String getName() {
        return name;
    }

    public boolean isValid(T value) {
        return rule.test(value);
    }
}
