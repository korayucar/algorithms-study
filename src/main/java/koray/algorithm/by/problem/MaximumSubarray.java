package koray.algorithm.by.problem;

/**
 * Solving the maximum subarray problem https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * Created by koray2 on 5/2/16.
 */

public class MaximumSubarray {


    /**
     * Kadenes algorithm for solving maximum subarray problem
     * runs in linear time.
     * @param arr
     * @return maximum subarray sum
     */
    public int findMaximumSubArrayByLinearSearch (int [] arr){
        int max_ending_here = 0 , max_so_far = 0;
        for (int i :arr){
            max_ending_here = Math.max(0 , max_ending_here + i);
            max_so_far = Math.max(max_so_far , max_ending_here);
        }
        return max_so_far;

    }

    /**
     *
     * solves the maximum subarray problem on Theta(nlgn) time which is not the best solution available
     * @param A the array
     * @param low beginning of the array
     * @param high end of the array indice inclusive
     * @return int [] of length 3 the beginning index of the max subarray, the end index of the max subarray
     *          and the sum of max subarray
     */
    public int[] findMaximumSubArrayByDivideAndConquer(int [] A , int low, int high){
        if(high == low) // when there is only one element left to consider
            return new int[]{low , high , A[low]};
        int mid = (low+high) / 2;
        int[] left = findMaximumSubArrayByDivideAndConquer(A , low,mid);
        int[] right = findMaximumSubArrayByDivideAndConquer(A,mid+1 , high);
        int[] crossing = findMaxCrossingSubarray(A , low, mid, high);
        if(left[2] > crossing[2] && left[2] > right [2])
            return left;
        else if(right[2] > crossing[2] && right[2] > left [2])
            return right;
        else return crossing;

    }

    /**
     * finds the sum of crossing  subarray between two parts of the array
     * @param A the array
     * @param low the starting index of the left array
     * @param mid the last index of the left array
     * @param high the last index of the right array
     * @return int [] of length 3 the beginning index of the max subarray, the end index of the max subarray
     *          and the sum of max subarray
     */
    private int [] findMaxCrossingSubarray ( int [] A  , int low , int mid , int high){

        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft =0;
        for (int i = mid ; i >= low ; i -- ){
            sum +=A[i];
            if(sum > leftSum)
            {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int maxRight = 0;
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid+1; i <= high ; i ++){
            sum+=A[i];
            if(sum > rightSum)
            {
                rightSum = sum ;
                maxRight = i;
            }
        }
        return new int[]{maxLeft , maxRight , leftSum + rightSum};
    }




}
