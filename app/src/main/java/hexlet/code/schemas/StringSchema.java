package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    private static final String REQUIRED_RULE = "required";
    private static final String MINLENGTH_RULE = "minLength";
    private static final String CONTAINS_RULE = "contains";


    public StringSchema required() {
        addCheck(REQUIRED_RULE, value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Minimal length cannot be negative");
        }

        addCheck(MINLENGTH_RULE, value -> value.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck(CONTAINS_RULE, value -> value.contains(substring));
        return this;
    }
}
