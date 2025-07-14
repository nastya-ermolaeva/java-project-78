package hexlet.code.schemas;

import java.util.List;
import java.util.LinkedList;
import hexlet.code.schemas.rules.ValidationRule;

public abstract class BaseSchema<T> {
    protected List<ValidationRule<T>> rules;

    public BaseSchema() {
        this.rules = new LinkedList<>();
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

        for (var rule : rules) {
            if (!rule.isValid(value)) {
                return false;
            }
        }

        return true;
    }
}
