package jobsearch;

public class HeightBalanced {

	public boolean isHeightBalanced(TreeNode<?> root) {
		if(root == null) return true;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		if(!isHeightBalanced(root.left)) return false;
		if(!isHeightBalanced(root.right)) return false;
		
		return (Math.abs(leftHeight - rightHeight) <= 1);
	}
	
	public static int height(TreeNode<?> root) {
		if(root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(func(2));
	}

	public static int func(int n) {
		if (n == 4) return 2;
		else
			return 2 * func(n+1);
	}
}
