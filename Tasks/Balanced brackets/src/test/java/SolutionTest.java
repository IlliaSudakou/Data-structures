

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {


    @ParameterizedTest(name="Run {index}: input={0}, expectedValue={1}")
    @MethodSource("testParameters")
    public void testSecondSolution(String input, String expectedValue) {
        assertEquals(expectedValue, Solution.process(input));
    }

    static Stream<Arguments> testParameters() throws Throwable {
        return Stream.of(
                Arguments.of("{{{}}}", "Success"),
                Arguments.of("{{(({}))[[[]]]}}", "Success"),
                Arguments.of("{dfsf{sdff{}[][][]{}}}[()", "23"),
                Arguments.of("(", "1"),
                Arguments.of("{wewewewe[{(0]{][][[]", "14"),
                Arguments.of("]", "1"),
                Arguments.of("[]", "Success"),
                Arguments.of("{}[]", "Success"),
                Arguments.of("[()]", "Success"),
                Arguments.of("(())", "Success"),
                Arguments.of("{[]}()", "Success"),
                Arguments.of("{[}", "3"),
                Arguments.of("foo(bar);", "Success"),
                Arguments.of("([](){([])})", "Success"),
                Arguments.of("{{[()]}", "1"),
                Arguments.of("foo(bar[i);", "10")
        );
    }

}
