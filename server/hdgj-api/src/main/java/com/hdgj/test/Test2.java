package com.hdgj.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.BasicBSONObject;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;

public class Test2 {
	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int i = 0; i < 100 ; i++) {
			arr[i] = i;
		}
		
		binarySearch(arr,88,0,99,0);
		binarySearch(arr,88);
	}
	
	//递归查找方法
	public static int binarySearch(int arr[],int guess,int low,int high ,int queryCount){
		int middle = ( low + high) / 2;
		queryCount++;
		if(low<high){
			if( arr[middle] == guess){
				System.out.println("找到元素下标:"+middle + ",查找次数：" + queryCount);
			}else if(guess < arr[middle]){
				//左边找
				binarySearch(arr,guess,low,middle-1,queryCount);
			}else if(guess > arr[middle]){
				//左边找
				binarySearch( arr,guess,middle+1,high ,queryCount);
			}
		}
		return queryCount;
	}
	
	//非递归查找方法
	public static void binarySearch(int[] list , int guess){
		int low = 0;
		int high = list.length - 1;		
		
		int count = 0;
		int mid;
		
		out:
		while (high >= low){
			mid = (high + low) / 2;
			count++;
			
			if ( mid == guess) {
				System.out.println("找到了元素:" + mid  + "一共查找了" + count + "次");
				break out; 
			}
			
			/**
			 * 如果猜大了，则修改最大值，如果猜小了，则修改最小值
			 */
			if ( mid > guess) {
				high = mid - 1;
				continue out;
			} else {
				low = mid + 1;
			}
	
		}
	}
}
