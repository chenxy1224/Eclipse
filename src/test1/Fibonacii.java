package test1;

public class Fibonacii {

	
	public static long fabonacci(int n){//非递归，O(n)
		int[] a = {0,1};
		if(n < 2) return a[n];
		
		long firstnum = a[0];
		long secondnum = a[1];
		long nNum = 0;
		for(int i = 2; i <= n; i++){
			nNum = firstnum + secondnum;
			firstnum = secondnum;
			secondnum = nNum;
		}
		return nNum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//java中的int类型存储长度为32bit.所以范围是“-2^31”到“2^31-1”;
		//java中的int类型存储长度为64bit.所以范围是“-2^63”到“2^63-1”;
		System.out.println("5 : " + fabonacci(5));
		System.out.println("3 : " + fabonacci(3));
		System.out.println("50 : " + fabonacci(50));

	}

}
