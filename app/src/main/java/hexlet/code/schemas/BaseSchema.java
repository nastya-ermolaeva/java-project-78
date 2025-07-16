package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> rules;

    public BaseSchema() {
        this.rules = new LinkedHashMap<>();
    }

    /**
     * Validates the input value against all the added validation rules.
     *
     * Subclasses may override this method if they need a custom validation strategy.
     * If overridden, make sure to include all relevant validation logic.
     *
     * @param value the value to validate
     * @return true if the value passes all validation rules, false otherwise
     */

    public boolean isValid(T value) {

        for (var rule : rules.values()) {
            if (!rule.test(value)) {
                return false;
            }
        }

        return true;
    }

    protected final void addCheck(String name, Predicate<T> rule) {
        rules.put(name, rule);
    }
}
