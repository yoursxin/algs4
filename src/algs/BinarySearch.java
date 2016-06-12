package algs;

import edu.princeton.cs.algs4.In;

public class BinarySearch {

	public static int rank(int key, int[] a){
				
		for(int low=0, high=a.length-1; low<=high; ){
						
			int mid = low + (high-low)/2; //ERR int mid = (low+high)/2;
			
			if(key == a[mid] ){
				return mid;
			}else if(key>a[mid]){
				low = mid+1; //ERR low = mid
			}else{
				high= mid-1; //ERR high = mid
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		

	}

}
