package hexlet.code.schemas;

import hexlet.code.schemas.rules.string.RequiredRule;
import hexlet.code.schemas.rules.string.MinLengthRule;
import hexlet.code.schemas.rules.string.ContainsRule;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        rules.add(new RequiredRule());
        return this;
    }

    public StringSchema minLength(int length) {
        rules.removeIf(rule -> rule instanceof MinLengthRule);
        rules.add(new MinLengthRule(length));
        return this;
    }

    public StringSchema contains(String substring) {
        rules.add(new ContainsRule(substring));
        return this;
    }
}
