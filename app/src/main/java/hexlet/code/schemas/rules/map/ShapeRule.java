package hexlet.code.schemas.rules.map;

import hexlet.code.schemas.rules.ValidationRule;
import hexlet.code.schemas.BaseSchema;
import java.util.Map;

public class ShapeRule<K, V> implements ValidationRule<Map<K, V>> {
    private Map<K, BaseSchema<V>> schemas;

    public ShapeRule(Map<K, BaseSchema<V>> schemas) {
        if (schemas == null || schemas.isEmpty()) {
            throw new IllegalArgumentException("Schemas for the shape rule must be filled");
        }
        this.schemas = schemas;
    }

    public boolean isValid(Map<K, V> data) {
        if (data == null) {
            return true;
        }

        for (var entry : schemas.entrySet()) {
            K key = entry.getKey();
            BaseSchema<V> schema = entry.getValue();
            V value = data.get(key);

            if (!schema.isValid(value)) {
                return false;
            }
        }

        return true;
    }
}
