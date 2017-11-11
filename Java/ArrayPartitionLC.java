import java.util.Scanner;


public class ArrayPartitionLC {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n;
	n=sc.nextInt();

	int array[] = new int[n];
	
	for(int i = 0; i<array.length;i++){
		array[i]=sc.nextInt();
		
	}
	
	int result [] =arrayPairSum(array);
	
	for(int i=0;i<result.length;i++){
		System.out.println(result[i]);
	}
	
	
}

public static int[] arrayPairSum(int nums[]){
	
	class mergeSort{
		
		public int[]  merge(int nums []){
			int a[] = new int[nums.length/2];
			int b[] = new int[nums.length - nums.length/2];
			
			for(int i=0;i<a.length;i++){
				a[i]= nums[i];
			}
			
			for(int j=0;j<b.length;j++){
				b[j] = nums[j+nums.length/2];
			}
			
			merge(a);
			merge(b);
			combine(nums,a,b);
			return nums;
			
		}
		
		public void combine(int nums[], int a[], int b[]){
			int i1=0;
			int i2=0;
			for(int k=0;k<nums.length;k++){
				if(i2 >= b.length || i1 < a.length && a[i1]< b[i2]){
					nums[k]=a[i1];
					i1++;
				}
				else{
					nums[k]=b[i2];
					i2++;
				}
					
			}
		}
		
		
	}
	
	
	return new mergeSort().merge(nums);
	//return 0;
	
}
public int arrayPairSum(int[] nums) {
	int min [] = new int[nums.length/2];
int j=0;
for(int i=0;i<nums.length-1;i=i+2){

	min[j] = Math.min(nums[i],nums[i+1]);
	j++;


	
}
int sum=0;
for(int i=0;i<min.length;i++){
sum +=min[i];
}



return sum;

}


}
