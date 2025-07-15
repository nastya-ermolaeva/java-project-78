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
        schema.sizeof(0);
        assertTrue(schema.isValid(data));

        data.put("key1", "value1");
        assertFalse(schema.isValid(data));

        schema.sizeof(2);

        data.put("key1", "value2");
        assertFalse(schema.isValid(data));

        data.put("key2", "value2");
        assertTrue(schema.isValid(data));

        assertThrows(IllegalArgumentException.class, () -> schema.sizeof(-2));
    }

    @Test
    void shapeRuleWithStringTest() {
        var v = new Validator();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("first name", v.string().required());
        schemas.put("last name", v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("first name", "John");
        human1.put("last name", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("first name", "John");
        human2.put("last name", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("first name", "Anna");
        human3.put("last name", "B");
        assertFalse(schema.isValid(human3));

        Map<String, BaseSchema<String>> schemas2 = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> schema.shape(schemas2));
    }

    @Test
    void shapeRuleWithNumberTest() {
        var v = new Validator();
        Map<String, BaseSchema<Integer>> schemas = new HashMap<>();
        schemas.put("age", v.number().required().positive());
        schemas.put("experience", v.number().required().positive().range(5, 30));

        schema.shape(schemas);

        Map<String, Integer> candidate1 = new HashMap<>();
        candidate1.put("age", 20);
        candidate1.put("experience", 2);
        assertFalse(schema.isValid(candidate1));

        Map<String, Integer> candidate2 = new HashMap<>();
        candidate2.put("age", 30);
        candidate2.put("experience", 10);
        assertTrue(schema.isValid(candidate2));

        Map<String, Integer> candidate3 = new HashMap<>();
        candidate3.put("age", 10);
        candidate3.put("experience", null);
        assertFalse(schema.isValid(candidate3));
    }

    @Test
    void combinedRulesTest() {
        schema.required().sizeof(0);

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(data));

        data.put("key1", "value1");
        data.put("key2", "value2");

        schema.sizeof(2);

        assertTrue(schema.isValid(data));

        schema.sizeof(0);

        assertFalse(schema.isValid(data));
    }
}
