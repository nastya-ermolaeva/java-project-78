package hexlet.code.schemas;

import hexlet.code.schemas.rules.number.RequiredRule;
import hexlet.code.schemas.rules.number.PositiveRule;
import hexlet.code.schemas.rules.number.RangeRule;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        rules.add(new RequiredRule());
        return this;
    }

    public NumberSchema positive() {
        rules.add(new PositiveRule());
        return this;
    }

    public NumberSchema range(int begin, int end) {
        rules.add(new RangeRule(begin, end));
        return this;
    }
}
