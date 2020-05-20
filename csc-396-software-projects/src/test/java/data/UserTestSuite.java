/**
 * Tests for Student class
 */

package data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//Run tests on student class
public class UserTestSuite {

    /*
    All Constructor Tests
     */

    //Test that null inputs throws NullPointerException
    @ParameterizedTest(name = "Null name or password throws NullPointerException")
    @MethodSource("studentNullTests")
    void studentNullTest(String name, String pass) {
        assertThrows(NullPointerException.class, () -> new Student(name, pass));
    }

    private static Stream<Arguments> studentNullTests() {
        return Stream.of(
                Arguments.of(null, "jiggly69"),
                Arguments.of("Billy Bob", null)
        );
    }

    //Test that blank input or input with no letters throws IllegalArgumentException
    @ParameterizedTest(name = "Blank or empty string name or password throws NullPointerException")
    @MethodSource("studentIllegalStringTests")
    void studentIllegalStringTest(String name, String pass) {
        assertThrows(IllegalArgumentException.class, () -> new Student(name, pass));
    }

    private static Stream<Arguments> studentIllegalStringTests() {
        return Stream.of(
                Arguments.of("", "jiggly69"),
                Arguments.of(" ", "jiggly69"),
                Arguments.of("Billy Bob", ""),
                Arguments.of("Billy Bob", " ")
        );
    }

    //Verify student constructor inputs are correct
    //Test that null inputs throws NullPointerException
    @ParameterizedTest(name = "Verify constructor inputs are correct")
    @MethodSource("studentConstructorTests")
    void studentConstructorTest(String name, String pass, Student expected) {
        Student kid = new Student(name, pass);
        assertEquals(expected, kid);
    }

    private static Stream<Arguments> studentConstructorTests() {
        return Stream.of(
                Arguments.of("Bill Gates", "Microsoft", new Student("Bill Gates", "Microsoft")),
                Arguments.of("Steve Jobs", "Apple", new Student("Steve Jobs", "Apple"))
        );
    }

}
