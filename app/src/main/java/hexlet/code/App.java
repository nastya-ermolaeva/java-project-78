package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.number();

        System.out.println(schema.isValid(5));
        System.out.println(schema.isValid(null));
        System.out.println(schema.positive().isValid(null));

        schema.required();

        System.out.println(schema.isValid(null));
        System.out.println(schema.isValid(10));

        System.out.println(schema.isValid(-10));
        System.out.println(schema.isValid(0));

        schema.range(5, 10);

        System.out.println(schema.isValid(5));
        System.out.println(schema.isValid(10));
        System.out.println(schema.isValid(4));
        System.out.println(schema.isValid(11));
    }
}
