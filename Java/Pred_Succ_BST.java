package BinarySearchTree;

public class Pred_Succ_BST {

	class Node {
		Node left;
		Node right;
		int data;
	}

	static Node root;

	public boolean insert(int value) {
		Node newNode = new Node();
		newNode.data = value;

		if (root == null) {
			root = newNode;
			return true;
		} else {
			Node curr = root;
			Node parent = null;
			boolean isLeft = true;
			while (curr != null) {
				parent = curr;
				if (curr.data > value) {
					curr = curr.left;
					isLeft = true;
				} else {
					curr = curr.right;
					isLeft = false;
				}
			}

			if (isLeft) {
				parent.left = newNode;
				return true;
			} else {
				parent.right = newNode;
				return true;
			}

		}
	}

	public void traverse() {
		traversal(root);
	}

	public static void traversal(Node root) {
		if (root != null) {
			traversal(root.left);
			System.out.println(root.data);
			traversal(root.right);
		}
	}

	public static Node findNode(int val) {
		if (root == null) {
			return null;
		}

		else {
			Node curr = root;
			while (curr.data != val) {
				if (val < curr.data) {
					curr = curr.left;
				}

				else {
					curr = curr.right;
				}

				if (curr == null) {
					return null;
				}
			}

			return curr;

		}

	}

	public int inOrderPre(int val) {
		if (root.data == val) {

			return root.left.data;
		}

		else {
			Node pos = findNode(val);
			if (pos == null) {
				System.out.println("This node is not present in the tree");
				return 0;
			} else {
				if (pos.left != null) {
					pos = pos.left;
					while (pos != null) {
						pos = pos.right;
					}
					return pos.data;
				}

				else {
					// System.out.println(root.data+ "This is root");
					int lastRight = 0;
					Node curr = root;
					while (curr != null) {
						if (pos.data < curr.data) {
							curr = curr.left;
						} else {
							if (curr.data != pos.data)
								lastRight = curr.data;
							curr = curr.right;
							// lastRight = curr.data;
						}
					}

					return lastRight;

				}

			}

		}

	}

	public int inOrderSucc(int val) {

		Node curr = root;
		Node parent = root;
		Node pos = findNode(val);
		if (pos == null) {
			System.out.println("Element not in tree");
			return -1;
		}
		if (pos.right != null) {
			curr = pos.right;
			parent = curr;
			while (curr != null) {
				parent = curr;
				curr = curr.left;
			}
			return parent.data;
		}

		else {

			int succ = -1;
			Node prev;
			while (curr.data != val) {
				if (val < curr.data) {
					succ = curr.data;
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			}
			return succ;

		}
	}

	public static void main(String[] args) {
		Pred_Succ_BST obj = new Pred_Succ_BST();
		obj.insert(10);
		obj.insert(89);
		obj.insert(65);
		obj.insert(99);
		obj.insert(100);
		obj.insert(2);
		obj.insert(1);
		// obj.traverse();

		System.out.println(obj.inOrderPre(99));
		System.out.println(obj.inOrderSucc(2));
	}

}
