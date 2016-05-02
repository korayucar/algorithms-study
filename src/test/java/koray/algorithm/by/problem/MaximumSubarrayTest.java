package koray.algorithm.by.problem;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by koray2 on 5/2/16.
 */
public class MaximumSubarrayTest {



    @Test
    public void testFindMaximumSubArray() throws Exception {

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int [] arr = new int [] {4,5,-3,9,62,-23,9,-6,-23,9,1,8,12};
        int [] res =maximumSubarray.findMaximumSubArrayByDivideAndConquer(arr , 0 , arr.length -1);
        assertEquals(res[0],0);
        assertEquals(res[1],4);
        assertEquals(res[2],77);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testFindMaximumSubArray2() throws Exception {

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int [] arr = new int [] {4,5,-3,9,62,0,3,-6,-23,9,1,8,12};
        int [] res =maximumSubarray.findMaximumSubArrayByDivideAndConquer(arr , 0 , arr.length -1);
        System.out.println(Arrays.toString(res));
        assertEquals(res[0],0);
        assertEquals(res[1],12);
        assertEquals(res[2],81);
    }

    @Test
    public void testFindMaximumSubArray3() throws Exception {

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int [] arr = new int [] {4,5,-3,9,62,0,0,-6,-23,9,1,8,7};
        int [] res =maximumSubarray.findMaximumSubArrayByDivideAndConquer(arr , 0 , arr.length -1);
        System.out.println(Arrays.toString(res));
        assertEquals(res[0],0);
        assertEquals(res[1],4);
        assertEquals(res[2],77);
    }
}