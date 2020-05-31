package data;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Statistics Set Test Class
 */

//Run tests on StatisticsSet class
public class StatisticsSetTestSuite {

    //Constructor Test
    @ParameterizedTest(name = "Test all arguments of StatisticsSet constructor")
    @MethodSource("StatisticsSetConstructor")
    void StatisticsSetConstructorTest() {
        StatisticsSet s = new StatisticsSet(User u, int ct, int ta, int tc, double ur, int num);
    }

    private static Stream<Arguments> studentEqualsTests() {
        return Stream.of(
                Arguments.of(new UserStudent("Gob Bluthe", "arrested3"), ),
                Arguments.of("Larry Finch", "weenie", "Connie Finch", "weenie", false),
                Arguments.of("John Brown", "junk20", "John Brown", "junk30", false)
        );
    }
}
