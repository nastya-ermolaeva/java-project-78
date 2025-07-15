package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberSchemaTest {

    private NumberSchema schema;

    @BeforeEach
    void init() {
        schema = new NumberSchema();
    }

    @Test
    void requiredRuleTest() {
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(0));
    }

    @Test
    void positiveRuleTest() {
        schema.positive();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
        assertFalse(schema.isValid(0));
    }

    @Test
    void rangeRuleTest() {
        schema.range(5, 10);

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));

        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
        assertFalse(schema.isValid(-5));

        assertThrows(IllegalArgumentException.class, () -> schema.range(10, 5));
    }

    @Test
    void combinedRulesTest() {
        schema.required().positive().range(-5, 5);

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-5));
        assertTrue(schema.isValid(4));
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(10));
    }
}
