package hexlet.code;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.map();

        System.out.println(schema.isValid(null));

        schema.required();

        System.out.println(schema.isValid(null));
        System.out.println(schema.isValid(new HashMap<>()));

        var data = new HashMap<String, String>();
        data.put("key1", "value1");

        System.out.println(schema.isValid(data));

        schema.sizeof(2);

        System.out.println(schema.isValid(data));

        data.put("key2", "value2");

        System.out.println(schema.isValid(data));
    }
}
