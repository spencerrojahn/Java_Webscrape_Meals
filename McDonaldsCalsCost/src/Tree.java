
public class Tree {

	Node root;
	
	public void addNode(Items item) {
		
		Node newNode = new Node(item);
		if (root == null ) {
			root = newNode;
		} else {
			Node curr = root;
			Node parent;
			while(true) {
				parent = curr;
				if (item.getCalToPriceRatio() < curr.item.getCalToPriceRatio()) {
					curr = curr.leftChild;
					if (curr == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					curr = curr.rightChild;
					if (curr == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}	
		}
	}
	
	int count = 0;
	public void reverseInOrder(Node curr) {
		if(curr != null) {
			reverseInOrder(curr.rightChild);
			count++;
			System.out.println(count + ") "+ curr.item.getItem() + ", CAL: " + curr.item.getCalories() + ", PRICE: " + curr.item.getPrice());
			reverseInOrder(curr.leftChild);
		}
	}
	
}

class Node {
	
	Items item;
	
	Node leftChild;
	Node rightChild;
	
	public Node(Items item) {
		this.item = item;
		this.leftChild = null;
		this.rightChild = null;
	}
	
}