package jobsearch;

public class TreeNode<T> {
	private T data;
	TreeNode<?> left;
	TreeNode<? >right;
	
	TreeNode() {
		left = null;
		right = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
