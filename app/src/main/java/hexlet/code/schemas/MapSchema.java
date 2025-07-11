package hexlet.code.schemas;

import hexlet.code.schemas.rules.map.RequiredRule;
import hexlet.code.schemas.rules.map.SizeRule;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        rules.add(new RequiredRule());
        return this;
    }

    public MapSchema sizeof(int size) {
        rules.removeIf(rule -> rule instanceof SizeRule);
        rules.add(new SizeRule(size));
        return this;
    }
}
