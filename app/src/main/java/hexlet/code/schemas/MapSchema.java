package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    private static final String REQUIRED_RULE = "required";
    private static final String SIZE_RULE = "sizeof";
    private static final String SHAPE_RULE = "shape";

    public MapSchema required() {
        addCheck(REQUIRED_RULE, value -> value != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("The map size cannot be negative");
        }

        rules.removeIf(rule -> rule.getName().equals(SIZE_RULE));
        addCheck(SIZE_RULE, value -> value == null || value.size() == size);
        return this;
    }

    public <K, V> MapSchema shape(Map<K, BaseSchema<V>> schemas) {
        if (schemas == null || schemas.isEmpty()) {
            throw new IllegalArgumentException("Schemas for the shape rule must be filled");
        }

        addCheck(SHAPE_RULE, data -> {
            if (data == null) {
                return true;
            }

            for (var entry : schemas.entrySet()) {
                K key = entry.getKey();
                BaseSchema<V> schema = entry.getValue();
                V value = (V) data.get(key);

                if (!schema.isValid(value)) {
                    return false;
                }
            }

            return true;
        });

        return this;
    }
}
