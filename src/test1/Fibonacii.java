package test1;

public class Fibonacii {

	
	public static long fabonacci(int n){//�ǵݹ飬O(n)
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
		//java�е�int���ʹ洢����Ϊ32bit.���Է�Χ�ǡ�-2^31������2^31-1��;
		//java�е�int���ʹ洢����Ϊ64bit.���Է�Χ�ǡ�-2^63������2^63-1��;
		System.out.println("5 : " + fabonacci(5));
		System.out.println("3 : " + fabonacci(3));
		System.out.println("50 : " + fabonacci(50));

	}

}
