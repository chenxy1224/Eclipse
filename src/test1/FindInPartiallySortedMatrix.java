package test1;

public class FindInPartiallySortedMatrix {

	public static boolean find(int[][] matrix, int rows, int columns, int number)
	{
		int rownum = 0;
		--rows;
		int columnum = --columns;
		while(rownum <= rows && columnum >=0){
			int cmp = matrix[rownum][columnum];
			if(cmp == number) {
				System.out.println("find " + matrix[rownum][columnum] +" at (" 
			+ (rownum+1) + ", " + (columnum+1) + ") ");
				return true;
			}
			else if(cmp > number){
				columnum--;
			}
			else {
				rownum++;
			}
		}
		System.out.println("not find " + number);
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		//System.out.println(a.length);
		//System.out.println(a[1].length);
		find(a, 4, 4, 6);
		find(a, 4, 4, 5);

	}

}
