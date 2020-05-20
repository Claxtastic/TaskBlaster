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
        assertThrows(NullPointerException.class, () -> new UserStudent(name, pass));
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
        assertThrows(IllegalArgumentException.class, () -> new UserStudent(name, pass));
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
    void studentConstructorTest(String name, String pass, UserStudent expected) {
        UserStudent kid = new UserStudent(name, pass);
        assertEquals(expected, kid);
    }

    private static Stream<Arguments> studentConstructorTests() {
        return Stream.of(
                Arguments.of("Bill Gates", "Microsoft", new UserStudent("Bill Gates", "Microsoft")),
                Arguments.of("Steve Jobs", "Apple", new UserStudent("Steve Jobs", "Apple"))
        );
    }

    //Test getName method
    @ParameterizedTest(name = "getName method returns username")
    @MethodSource("studentGetNameTests")
    void studentGetNameTest(String name, String pass, String expected) {
        UserStudent kid = new UserStudent(name, pass);
        assertEquals(expected, kid.getName());
    }

    private static Stream<Arguments> studentGetNameTests() {
        return Stream.of(
                Arguments.of("Jimbo Jones", "boobs","Jimbo Jones"),
                Arguments.of("Larry Finch", "weenie", "Larry Finch")
        );
    }

    //Test setName method
    @ParameterizedTest(name = "setName method sets a new username")
    @MethodSource("studentSetNameTests")
    void studentSetNameTest(String name, String pass, String newName, String expected) {
        UserStudent kid = new UserStudent(name, pass);
        kid.setName(newName);
        assertEquals(expected, kid.getName());
    }

    private static Stream<Arguments> studentSetNameTests() {
        return Stream.of(
                Arguments.of("Jimbo Jones", "boobs","Billy Bob", "Billy Bob"),
                Arguments.of("Larry Finch", "weenie", "Burt Biggles", "Burt Biggles")
        );
    }

    //Test getPassword method
    @ParameterizedTest(name = "getPassword method returns password")
    @MethodSource("studentGetPasswordTests")
    void studentGetPasswordTest(String name, String pass, String expected) {
        UserStudent kid = new UserStudent(name, pass);
        assertEquals(expected, kid.getPassword());
    }

    private static Stream<Arguments> studentGetPasswordTests() {
        return Stream.of(
                Arguments.of("Jimbo Jones", "boobs","boobs"),
                Arguments.of("Larry Finch", "weenie", "weenie")
        );
    }

    //Test setPassword method
    @ParameterizedTest(name = "setPassword method sets a new password")
    @MethodSource("studentSetPasswordTests")
    void studentSetPasswordTest(String name, String pass, String newPassword, String expected) {
        UserStudent kid = new UserStudent(name, pass);
        kid.setPassword(newPassword);
        assertEquals(expected, kid.getPassword());
    }

    private static Stream<Arguments> studentSetPasswordTests() {
        return Stream.of(
                Arguments.of("Jimbo Jones", "boobs","breasts", "breasts"),
                Arguments.of("Larry Finch", "weenie", "hot dog", "hot dog")
        );
    }

}
