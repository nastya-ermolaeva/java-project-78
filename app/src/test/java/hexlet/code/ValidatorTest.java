package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;

class ValidatorTest {
    private Validator v;

    @BeforeEach
    void init() {
        v = new Validator();
    }

    @Test
    void stringSchemaTest() {
        var schema = v.string();

        assertNotNull(schema);
        assertTrue(schema instanceof StringSchema);
    }

    @Test
    void numberSchemaTest() {
        var schema = v.number();

        assertNotNull(schema);
        assertTrue(schema instanceof NumberSchema);
    }

    @Test
    void mapSchemaTest() {
        var schema = v.map();

        assertNotNull(schema);
        assertTrue(schema instanceof MapSchema);
    }
}
