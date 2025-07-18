package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;


public final class Validator {
    public Validator() { }

    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public MapSchema map() {
        return new MapSchema();
    }
}
