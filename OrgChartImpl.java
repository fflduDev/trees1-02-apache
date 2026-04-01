package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	
	public void addRoot(Employee e){
		GenericTreeNode<Employee> rootEmployee = new GenericTreeNode<Employee>(e);
		nodes.add(rootEmployee);
	}
		// if there is no orgchart, start it
	
	
	public void clear(){
		nodes.clear();
		System.out.println("OrgChart cleared.");
	}
		// get rid of the org chart
	
	public void addDirectReport(Employee manager, Employee newPerson){
		for (int i = 0; i < nodes.size(); i++) {
			GenericTreeNode<Employee> node = nodes.get(i);
			if (node.data.equals(manager)){
				GenericTreeNode<Employee> newE = new GenericTreeNode<>(newPerson);
				node.children.add(newE);
				nodes.add(newE);
				break;
			}
		}	
	}
		// add the newPerson as a direct report (child) of manager
	
	public void removeEmployee(Employee firedPerson){
		Queue<GenericTreeNode<Employee>> queue = new LinkedList<GenericTreeNode<Employee>>();
		queue.add(nodes.get(0));

		while (!queue.isEmpty()) {
			GenericTreeNode<Employee> curr = queue.poll();

			for (GenericTreeNode<Employee> child : curr.children){
				if(child.equals(firedPerson)) {
					curr.removeChild(firedPerson);
				}

				queue.add(child);
			}
		}
	}
		// remove the employee, give their direct reports to their supervisor
	
	public void showOrgChartDepthFirst() {
		Stack<GenericTreeNode<Employee>> stack = new Stack<>();
		stack.push(nodes.get(0));   // root

		while (!stack.isEmpty()) {
			GenericTreeNode<Employee> curr = stack.pop();
			System.out.print(curr.data + " ");

			ArrayList<GenericTreeNode<Employee>> children = curr.children;

			for (int i = children.size() - 1; i >= 0; i--) {
				stack.push(children.get(i));
			}
    }
}
	
	public void showOrgChartBreadthFirst(){
		Queue<GenericTreeNode<Employee>> queue = new LinkedList<GenericTreeNode<Employee>>();
		queue.add(nodes.get(0));

		while (!queue.isEmpty()) {
			int n = queue.size();
			GenericTreeNode<Employee> curr = queue.poll();

			System.out.print(curr.data + " ");
			for (GenericTreeNode<Employee> child : curr.children){
				queue.add(child);
			}
			n--;
		}
	}
	
}
