package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringSchemaTest {

    private StringSchema schema;

    @BeforeEach
    void init() {
        schema = new StringSchema();
    }

    @Test
    void requiredRuleTest() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
    }

    @Test
    void minLengthRuleTest() {
        schema.minLength(10);

        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid("hexlet"));

        schema.minLength(4);

        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));

        assertThrows(IllegalArgumentException.class, () -> schema.minLength(-5));
    }

    @Test
    void containsRuleTest() {
        schema.contains("wh");
        assertTrue(schema.isValid("what does the fox say"));

        schema.contains("what");
        assertTrue(schema.isValid("what does the fox say"));

        schema.contains("whatthe");
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    void combinedRulesTest() {
        schema.required().minLength(2).contains("nu");

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("number"));
    }
}
