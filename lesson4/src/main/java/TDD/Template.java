package TDD;
/**
 * Interface for methods for different Template.
 */
public interface Template {
    String generate (String text,Pair[] values);
    boolean validate (String text);
}