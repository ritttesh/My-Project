package DSA;

public class BST {
	class Node{
		int key;
		Node left=null,right=null;
		
		Node(int key){
			this.key=key;
		}
		
	}
//	Node root;
//	BST(){
//		root=new Node();
//	}
	
	public Node insert(Node root,int key ) {
		if(root==null) {
			root=new Node(key);;
			root.left=root.right=null;
		}
		else if(key<root.key) {
			root.left=insert(root.left,key);
		}
		else {
			root.right=insert(root.right,key);
		}
		
		return root;
	}
	public void inorder(Node root) {
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.println(root.key);
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		int[] nodes= {4,10,1,9,8,5,6,3};
		BST tree=new BST();
		Node root=null;
		for(int i:nodes) {
			root=tree.insert(root,i);
		}
		tree.inorder(root);
		
	}

}
