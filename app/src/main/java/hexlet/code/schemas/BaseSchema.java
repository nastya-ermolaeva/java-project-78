package hexlet.code.schemas;

import java.util.List;
import java.util.LinkedList;
import hexlet.code.schemas.rules.ValidationRule;

public abstract class BaseSchema<T> {
    protected List<ValidationRule<T>> rules;

    public BaseSchema() {
        this.rules = new LinkedList<>();
    }

    public boolean isValid(T value) {

        for (var rule : rules) {
            if (!rule.isValid(value)) {
                return false;
            }
        }

        return true;
    }
}
