package test1;

import java.util.Stack;


public class BinTree {// ʵ�ֶ�������ǰ�����������������������������أ��ݹ飬�ǵݹ飩�㷨���Լ���ص����ָ��㷨

	private int val;
	private BinTree lchild;
	private BinTree rchild;

	public BinTree(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}

	// ��������ݹ� :������
	public static void preOrder(BinTree t) {
		if (t == null)
			return;
		System.out.print(t.val + " ");
		preOrder(t.lchild);
		preOrder(t.rchild);

	}

	// ��������ݹ� : ������
	public static void InOrder(BinTree t) {
		if (t == null)
			return;
		InOrder(t.lchild);
		System.out.print(t.val + " ");
		InOrder(t.rchild);
	}

	// ��������ݹ� ������
	public static void PostOrder(BinTree t) {
		if (t == null)
			return;
		PostOrder(t.lchild);
		PostOrder(t.rchild);
		System.out.print(t.val + " ");
	}

	// ��������ǵݹ� ������
	public static void preOrder2(BinTree t) {
		Stack<BinTree> stack = new Stack<BinTree>();
		while (t != null || !stack.empty()) {
			while (t != null) {
				System.out.print(t.val + " ");
				stack.push(t);
				t = t.lchild;
			}
			if( !stack.empty()){
				t = stack.pop();
				t = t.rchild;
			}
		}
	}

	// ��������ǵݹ� ������
	public static void InOrder2(BinTree t) {
		Stack<BinTree> stack = new Stack<BinTree>();
		while(t != null || !stack.empty()){
			while(t != null){
				stack.push(t);
				t = t.lchild;
			}
			if(!stack.empty()){
				t = stack.pop();
				System.out.print(t.val + " ");
				t = t.rchild;
			}
		}		
	}

	// ��������ǵݹ飺 ������  (˼��:���� ��������������ڼ���ջ������������������ջ����� ������)
	public static void PostOrder2(BinTree t) {
		
		Stack<BinTree> stack = new Stack<BinTree>();
		Stack<BinTree> output = new Stack<BinTree>();//����һ���м�ջ���洢���������Ľ��
		
		while(t != null || !stack.empty()){
			while(t != null){
				stack.push(t);
				output.push(t);
				t = t.rchild;
			}
			
			if(!stack.empty()){
				t = stack.pop();
				t = t.lchild;
			}
		}
		while(!output.isEmpty()){
			System.out.print(output.pop().val +" ");
		}
		
//		Stack<BinTree> stack = new Stack<BinTree>();
//	    Stack<BinTree> output = new Stack<BinTree>();//����һ���м�ջ���洢���������Ľ��
//	    BinTree node = t;
//	    while (node != null || stack.size() > 0) {
//	      if (node != null) {
//	        output.push(node);
//	        stack.push(node);				
//	        node = node.rchild;
//	      } else {
//	        node = stack.pop();				
//	        node = node.lchild;
//	        
//	      }
//	    }
//	    while (output.size() > 0) {
//	      System.out.print(output.pop().val + " ");
//	    }
	}
	
	
	//����ǰ��������������������������������������
	public static BinTree construct(int[] preOrder, int[] inOrder){
		if(preOrder == null || inOrder == null )
			return null;
		int length = preOrder.length;
		return construct(0, length-1, 0, length-1, preOrder, inOrder);
	}
	
	private static BinTree construct(int preOrderStart, int preOrderEnd,
			int inOrderStart, int inOrderEnd,int[] preOrder,int[] inOrder){
		if(preOrderStart > preOrderEnd || inOrderStart > inOrderEnd){
			return null;
		}
		int rootval = preOrder[preOrderStart];
		BinTree root = new BinTree(rootval);//��������ĵ�һ���Ǹ�������root��
		int inOrderRootIndex;
		for(inOrderRootIndex = inOrderStart; inOrderRootIndex <= inOrderEnd; inOrderRootIndex++){
			if(inOrder[inOrderRootIndex] == rootval)
				break;
		}//�ҵ��������и��ڵ��λ�ã����ڵ���Ϊ�����������ڵ��Ҳ�Ϊ������
		int leftLength = inOrderRootIndex - inOrderStart;
		int rightLength = inOrderEnd-inOrderRootIndex;
		if(leftLength > 0){
			root.lchild = construct(preOrderStart+1, preOrderStart+leftLength, 
					inOrderStart, inOrderRootIndex-1, preOrder, inOrder);
		}
		if(rightLength > 0){
			root.rchild = construct(preOrderEnd-rightLength+1, preOrderEnd, 
					inOrderRootIndex+1, inOrderEnd, preOrder, inOrder);
		}
		return root;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���Ĺ���ͼ����ָoffer��54ҳ
		BinTree b1 = new BinTree(10);
		BinTree b2 = new BinTree(6);
		BinTree b3 = new BinTree(14);
		BinTree b4 = new BinTree(4);
		BinTree b5 = new BinTree(8);
		BinTree b6 = new BinTree(12);
		BinTree b7 = new BinTree(16);
		b1.lchild = b2;
		b1.rchild = b3;
		b2.lchild = b4;
		b2.rchild = b5;
		b3.lchild = b6;
		b3.rchild = b7;
		System.out.println("Preorder:");
		preOrder(b1);
		System.out.println();
		System.out.println("Preorder2:");
		preOrder2(b1);
		System.out.println();
		System.out.println("Inorder:");
		InOrder(b1);
		System.out.println();
		System.out.println("Inorder:");
		InOrder2(b1);
		System.out.println();
		System.out.println("Postorder:");
		PostOrder(b1);
		System.out.println();
		System.out.println("Postorder:");
		PostOrder2(b1);
		System.out.println();
		
		
		System.out.println("test treeConstcuctor:");
		int[] preorder = {10, 6, 4, 8, 14, 12, 16};
		int[] inorder = {4, 6, 8, 10, 12, 14, 16};
		BinTree root =  construct(preorder, inorder);
		System.out.println("Preorder:");
		preOrder(root);
		System.out.println();
		System.out.println("Inorder:");
		InOrder(root);
		System.out.println();
		System.out.println("Postorder:");
		PostOrder(root);
		System.out.println();
		

	}

}