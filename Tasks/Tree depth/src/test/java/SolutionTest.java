import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {


    @ParameterizedTest(name="Run {index}: input={0}, expectedValue={1}")
    @MethodSource("testParameters")
    public void testSecondSolution(String input, int expectedValue) {
        assertEquals(expectedValue, Solution.getDepth(input));
    }

    static Stream<Arguments> testParameters() throws Throwable {
        return Stream.of(
                Arguments.of("4 -1 4 1 1", 3),
                Arguments.of("-1 0 4 0 3", 4),
                Arguments.of("9 7 5 5 2 9 9 9 2 -1", 4),
                Arguments.of("-1", 1),
                Arguments.of("1 -1", 2),
                Arguments.of("-1 0 1 2 3 4 5 6 7", 9)
        );
    }
}
