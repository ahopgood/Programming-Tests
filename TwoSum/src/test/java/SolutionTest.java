import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Alexander on 05/11/2016.
 */
public class SolutionTest {

    int[] input = new int[]{3,2,4};
    int target = 6;

    @Test
    public void testTwoSum() throws Exception {
        Solution sol = new Solution();
        assertEquals(1, sol.twoSum(input, target)[0]);
        assertEquals(2, sol.twoSum(input, target)[1]);
    }


}