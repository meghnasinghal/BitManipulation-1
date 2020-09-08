// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int singleNumber(int[] nums) {
        int bitmask = 0;
        
        for(int num: nums)
        {
            bitmask ^= num; // taking xor and eliminating the duplicates as 1^1 = 0 so we are left with single number
        }
        
        return bitmask;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public int[] singleNumber(int[] nums) {
      int bitmask = 0; 
       
        for(int num : nums)
        {
            bitmask ^= num; // taking xor and eliminating the duplicates as 1^1 = 0 so we are left with xor of remaining two single number
        }
        int bitmask2 = 0;
        int diff = bitmask & (-bitmask); // finding 2's complement of bitmask and finding the AND with original bitmask
        
        for(int num :nums) // iterating over all the numbers
        {
            if((num & diff) != 0) // for each number except one present in bitmask, we will enter this condition
                bitmask2 ^= num; // on taking xor the duplicates cancel out and we are left with a one single number
        }
        
        return new int[] {bitmask2, (bitmask ^ bitmask2)}; // second single number can be found by taking xor with bitmask as bitmask will contain the found number and 1^1 = 0 so we will be left with the other one
    }
}

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int divide(int dividend, int divisor) {
        //edge case
        if(dividend == 0)
            return 0;
        if(divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        
        long ldividend = Math.abs((long)dividend); // taking positive value of both dividend and divisor
        long ldivisor = Math.abs((long)divisor);
        int result = 0;
        while(ldividend >= ldivisor) // till the dividend is greater or equal
        {
            int numShifts = 0;
            
            while(ldividend >= ldivisor << numShifts) // shift divisor till it becomes greater than dividend (calculating the quotient)
                numShifts++; 
            
            numShifts--; // we over shoot so reduce one
            result += 1 << numShifts; // result = 2^ shifts
            ldividend = ldividend - (ldivisor << numShifts); // decrease the value from dividend ( getting the remainder)
        }
        
        if(dividend <0 && divisor< 0) // both negative
            return result;
        if(dividend > 0 && divisor > 0) // both positive
            return result;
        
        return -result; // any one is negative
    }
}