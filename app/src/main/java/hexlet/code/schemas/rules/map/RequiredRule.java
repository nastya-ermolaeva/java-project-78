package hexlet.code.schemas.rules.map;

import hexlet.code.schemas.rules.ValidationRule;
import java.util.Map;

public final class RequiredRule implements ValidationRule<Map<?, ?>> {
    public boolean isValid(Map<?, ?> value) {
        return value != null;
    }
}
