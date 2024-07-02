package com.UserApplication.users;

import java.util.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.UserApplication.users.Trie;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,0,0,0,1,1,1,1};
		String[] x = { "ab", "a" };
		double a = 116161.94;
//		double y = interest(a,3.5,6);
//		System.out.println(y);
//		System.out.println(y-a);
//		System.out.println();
//		SimpleBeanPropertyFilter
//		MappingJacksonPro
		System.out.println(StringUtils.hasText(null));
	}
	
	public static double interest(double a, double r, int n) {
		double[] arr = new double[n];
		arr[0] = a;
		int i=1;
		r/=100;
		System.out.println(arr[0]);
		while(i<n) {
			arr[i] = arr[i-1]+arr[i-1]*r;
			System.out.println(arr[i]);
			i++;
		}
		
		return arr[n-1];
		
	}
	
	public static int longestOnes(int[] nums, int k) {

        if(k==0) return maxOnes(nums);

        int max = Integer.MIN_VALUE;
        int[] firstZero = new int[nums.length];
        int j=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                firstZero[j++]=i;
            }
        }
        if(j < k){
            return nums.length;
        }

        for(int i=0;i<j-k+1;i++){  
            for(int h=0;h<k;h++){
                nums[firstZero[h+i]]=1;
            }
            int ones = maxOnes(nums); 
            if(ones > max){
                max = ones;
            }
            for(int h=0;h<k;h++){
                nums[firstZero[h+i]]=0;
            }
        }

        return max;
    }

	static int maxOnes(int[] nums){
		int max = Integer.MIN_VALUE;
        int counter = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                counter++;
            }else{
            	if(max<counter) {
            		max = counter;
            	}
                counter=0;
            }
        }
        if(max<counter) {
    		max = counter;
    	}
        return max;
    }
}
