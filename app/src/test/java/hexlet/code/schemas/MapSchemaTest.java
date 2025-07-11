package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Map;
import java.util.HashMap;

class MapSchemaTest {

    private MapSchema schema;
    private Map<String, String> data;
    private static final int TWO = 2;
    private static final int MINUS_TWO = -2;
    private static final int ZERO = 0;
    private static final String KEY_1 = "key1";
    private static final String KEY_2 = "key2";
    private static final String VALUE_1 = "value1";
    private static final String VALUE_2 = "value2";


    @BeforeEach
    void init() {
        schema = new MapSchema();
        data = new HashMap<>();
    }

    @Test
    void requiredRuleTest() {
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(data));
    }

    @Test
    void sizeRuleTest() {
        schema.sizeof(ZERO);
        assertTrue(schema.isValid(data));

        data.put(KEY_1, VALUE_1);
        assertFalse(schema.isValid(data));

        schema.sizeof(TWO);

        data.put(KEY_1, VALUE_2);
        assertFalse(schema.isValid(data));

        data.put(KEY_2, VALUE_2);
        assertTrue(schema.isValid(data));

        assertThrows(IllegalArgumentException.class, () -> schema.sizeof(MINUS_TWO));
    }

    @Test
    void combinedRulesTest() {
        schema.required().sizeof(ZERO);

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(data));

        data.put(KEY_1, VALUE_1);
        data.put(KEY_2, VALUE_2);

        schema.sizeof(TWO);

        assertTrue(schema.isValid(data));

        schema.sizeof(ZERO);

        assertFalse(schema.isValid(data));
    }
}
