package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Map;
import java.util.HashMap;
import hexlet.code.Validator;

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
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String JOHN = "John";
    private static final String SMITH = "Smith";
    private static final String ANNA = "Anna";
    private static final String SHORT_NAME = "B";
    private static final String AGE = "age";
    private static final String EXPERIENCE = "experience";
    private static final int TEN = 10;
    private static final int FIVE = 5;
    private static final int TWENTY = 20;
    private static final int THIRTY = 30;


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
    void shapeRuleWithStringTest() {
        var v = new Validator();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put(FIRST_NAME, v.string().required());
        schemas.put(LAST_NAME, v.string().required().minLength(TWO));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put(FIRST_NAME, JOHN);
        human1.put(LAST_NAME, SMITH);
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put(FIRST_NAME, JOHN);
        human2.put(LAST_NAME, null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put(FIRST_NAME, ANNA);
        human3.put(LAST_NAME, SHORT_NAME);
        assertFalse(schema.isValid(human3));

        Map<String, BaseSchema<String>> schemas2 = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> schema.shape(schemas2));
    }

    @Test
    void shapeRuleWithNumberTest() {
        var v = new Validator();
        Map<String, BaseSchema<Integer>> schemas = new HashMap<>();
        schemas.put(AGE, v.number().required().positive());
        schemas.put(EXPERIENCE, v.number().required().positive().range(FIVE, THIRTY));

        schema.shape(schemas);

        Map<String, Integer> candidate1 = new HashMap<>();
        candidate1.put(AGE, TWENTY);
        candidate1.put(EXPERIENCE, TWO);
        assertFalse(schema.isValid(candidate1));

        Map<String, Integer> candidate2 = new HashMap<>();
        candidate2.put(AGE, THIRTY);
        candidate2.put(EXPERIENCE, TEN);
        assertTrue(schema.isValid(candidate2));

        Map<String, Integer> candidate3 = new HashMap<>();
        candidate3.put(AGE, TEN);
        candidate3.put(EXPERIENCE, null);
        assertFalse(schema.isValid(candidate3));
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
