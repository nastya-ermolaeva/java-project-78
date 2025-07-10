package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringSchemaTest {

    private StringSchema schema;
    private static final String VALUE_1 = "what does the fox say";
    private static final String VALUE_2 = "hexlet";
    private static final int TEN = 10;
    private static final int FOUR = 4;
    private static final int TWO = 2;

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
        assertTrue(schema.isValid(VALUE_1));
    }

    @Test
    void minLengthRuleTest() {
        schema.minLength(TEN);

        assertTrue(schema.isValid(VALUE_1));
        assertFalse(schema.isValid(VALUE_2));

        schema.minLength(FOUR);

        assertTrue(schema.isValid(VALUE_1));
        assertTrue(schema.isValid(VALUE_2));

        assertThrows(IllegalArgumentException.class, () -> schema.minLength(-5));
    }

    @Test
    void containsRuleTest() {
        schema.contains("wh");
        assertTrue(schema.isValid(VALUE_1));

        schema.contains("what");
        assertTrue(schema.isValid(VALUE_1));

        schema.contains("whatthe");
        assertFalse(schema.isValid(VALUE_1));
    }

    @Test
    void combinedRulesTest() {
        schema.required().minLength(TWO).contains("nu");

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("number"));
    }
}
