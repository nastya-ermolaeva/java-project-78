package hexlet.code.schemas.rules;

public interface ValidationRule<T> {
    boolean isValid(T value);
}
