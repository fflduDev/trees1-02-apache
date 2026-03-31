package tree;
import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	//<some list of children>
	ArrayList<GenericTreeNode<E>> children;
	
	public GenericTreeNode(E theItem) {
		data = theItem;
	}
	
	public void addChild(GenericTreeNode<E> theItem) {
		children.add(theItem);
	}
	
	public void removeChild(E theItem) {
		int i = 0;

		while(!children.get(i).equals(theItem) && i < children.size()) {
			i++;
		}

		if(i == children.size()){
			System.out.println("Item not found.");
			return;
		}

		GenericTreeNode<E> curr = children.get(i);

		if(curr.children.isEmpty()) {
			children.remove(curr);
			return;
		}

		int j = 0;

		while(j < curr.children.size()) {
			addChild(curr.children.get(j));
			j++;
		}

		children.remove(curr);
		
		// this one is a little harder.
		// what do you do when the item has children?
		// I suggest "give them to the parent"
	}
} 
