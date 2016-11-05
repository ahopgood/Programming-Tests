import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Alexander on 05/11/2016.
 */
public class SolutionTest {

    int[] input = new int[]{3,2,4};
    int target = 6;

    /**
     * This brute force approach was my solution.
     * This was more efficient than 36.49% of other people's solutions.
     * Most likely due to my loop bailing out at n-1.
     * Since reaching the last indice we already know there isn't a match as the second loop is on an n+1 look ahead
     * @throws Exception
     */
    @Test
    public void testBruteForce_TwoSum() throws Exception {
        BruteForceSolution sol = new BruteForceSolution();
        assertEquals(1, sol.twoSum(input, target)[0]);
        assertEquals(2, sol.twoSum(input, target)[1]);
    }

    @Test
    public void testTwoPassMap_TwoSum() throws Exception {
        TwoPassMap sol = new TwoPassMap();
        assertEquals(1, sol.twoSum(input, target)[0]);
        assertEquals(2, sol.twoSum(input, target)[1]);
    }

    @Test
    public void testOnePassMap_TwoSum() throws Exception {
        OnePassMap sol = new OnePassMap();
        assertEquals(1, sol.twoSum(input, target)[0]);
        assertEquals(2, sol.twoSum(input, target)[1]);
    }
}