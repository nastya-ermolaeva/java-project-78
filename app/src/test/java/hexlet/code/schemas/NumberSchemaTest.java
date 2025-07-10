package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberSchemaTest {

    private NumberSchema schema;
    private static final int FIVE = 5;
    private static final int MINUS_FIVE = -5;
    private static final int TEN = 10;
    private static final int FOUR = 4;
    private static final int ELEVEN = 11;
    private static final int ZERO = 0;

    @BeforeEach
    void init() {
        schema = new NumberSchema();
    }

    @Test
    void requiredRuleTest() {
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(ZERO));
    }

    @Test
    void positiveRuleTest() {
        schema.positive();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(FIVE));
        assertFalse(schema.isValid(MINUS_FIVE));
        assertFalse(schema.isValid(ZERO));
    }

    @Test
    void ramgeRuleTest() {
        schema.range(FIVE, TEN);

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(FIVE));
        assertTrue(schema.isValid(TEN));

        assertFalse(schema.isValid(FOUR));
        assertFalse(schema.isValid(ELEVEN));
        assertFalse(schema.isValid(MINUS_FIVE));

        assertThrows(IllegalArgumentException.class, () -> schema.range(TEN, FIVE));
    }

    @Test
    void combinedRulesTest() {
        schema.required().positive().range(MINUS_FIVE, FIVE);

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(ZERO));
        assertFalse(schema.isValid(MINUS_FIVE));
        assertTrue(schema.isValid(FOUR));
        assertTrue(schema.isValid(FIVE));
        assertFalse(schema.isValid(TEN));
    }
}
