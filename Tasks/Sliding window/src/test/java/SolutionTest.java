import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    @ParameterizedTest(name="Run {index}: n={0}, window={1}, expectedValue={2}")
    @MethodSource("testParameters")
    public void testSecondSolution(int[] n, int window, int[] expectedValue) {

        assertArrayEquals(expectedValue, Solution.getWindowsQueueMin(n, window));
    }

    @ParameterizedTest(name="Run {index}: n={0}, window={1}, expectedValue={2}")
    @MethodSource("testParametersMax")
    public void testSecondSolutionMax(int[] n, int window, int[] expectedValue) {

        assertArrayEquals(expectedValue, Solution.getWindowsQueueMaximum(n, window));
    }

    static Stream<Arguments> testParameters() throws Throwable {
        return Stream.of(
                Arguments.of(new int[] {2,7,3,1,5,2,6,2}, 4, new int[] {1,1,1,1,2} ),
                Arguments.of(new int[] {1,2,4,8,9}, 3, new int[] {1,2,4} ),
                Arguments.of(new int[] {1}, 1, new int[] {1} ),
                Arguments.of(new int[] {1,2,4,8,9}, 1, new int[] {1,2,4,8,9} ),
                Arguments.of(new int[] {100,99,98,97,96,95,94,93,90,85,80,75,70,65,60,55,50,45,40,35,30,25,20,15,10},
                        3, new int[] {98,97,96,95,94,93,90,85,80,75,70,65,60,55,50,45,40,35,30,25,20,15,10} ),
                Arguments.of(new int[] {1,2,4,8,9,0,5,1,1,1,1,1}, 8, new int[] {0,0,0,0,0} ),
                Arguments.of(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        2, new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} )
        );
    }

    static Stream<Arguments> testParametersMax() throws Throwable {
        return Stream.of(
                Arguments.of(new int[] {2,7,3,1,5,2,6,2}, 4, new int[] {7,7,5,6,6} ),
                Arguments.of(new int[] {1,2,4,8,9}, 3, new int[] {4,8,9} ),
                Arguments.of(new int[] {1}, 1, new int[] {1} ),
                Arguments.of(new int[] {1,2,4,8,9}, 1, new int[] {1,2,4,8,9} ),
                Arguments.of(new int[] {100,99,98,97,96,95,94,93,90,85,80,75,70,65,60,55,50,45,40,35,30,25,20,15,10},
                        3, new int[] {100,99,98,97,96,95,94,93,90,85,80,75,70,65,60,55,50,45,40,35,30,25,20} ),
                Arguments.of(new int[] {1,2,4,8,9,0,5,1,1,1,1,1}, 8, new int[] {9,9,9,9,9} ),
                Arguments.of(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        2, new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} )
        );
    }
}
