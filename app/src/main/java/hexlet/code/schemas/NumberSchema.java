package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    private static final String REQUIRED_RULE = "required";
    private static final String POSITIVE_RULE = "positive";
    private static final String RANGE_RULE = "range";

    public NumberSchema required() {
        addCheck(REQUIRED_RULE, value -> value != null);
        return this;
    }

    public NumberSchema positive() {
        addCheck(POSITIVE_RULE, value -> value == null || value.intValue() > 0);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        if (begin > end) {
            throw new IllegalArgumentException("Incorrect range: the beginning is greater than the end");
        }

        addCheck(RANGE_RULE, value -> value == null || (value.intValue() >= begin && value.intValue() <= end));
        return this;
    }
}
