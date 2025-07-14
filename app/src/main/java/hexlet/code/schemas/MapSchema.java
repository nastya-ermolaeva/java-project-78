package hexlet.code.schemas;

import hexlet.code.schemas.rules.map.RequiredRule;
import hexlet.code.schemas.rules.map.SizeRule;
import hexlet.code.schemas.rules.map.ShapeRule;
import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        rules.add(new RequiredRule());
        return this;
    }

    public MapSchema sizeof(int size) {
        rules.removeIf(rule -> rule instanceof SizeRule);
        rules.add(new SizeRule(size));
        return this;
    }

    public <K, V> MapSchema shape(Map<K, BaseSchema<V>> schemas) {
        rules.add(new ShapeRule(schemas));
        return this;
    }
}
