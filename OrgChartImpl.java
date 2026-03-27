package tree;

import java.util.ArrayList;
import java.util.List;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	
	public void addRoot(Employee e){
		GenericTreeNode<Employee> rootEmployee = new GenericTreeNode<Employee>(e);
		nodes.add(rootEmployee);
	}
		// if there is no orgchart, start it
	
	
	public void clear(){
		
	}
		// get rid of the org chart
	
	public void addDirectReport(Employee manager, Employee newPerson){
		for (int i = 0; i < nodes.size(); i++) {
			GenericTreeNode<Employee> node = nodes.get(i);
			if (currentEmployee.data.equals(manager)){
				GenericTreeNode<Employee> newE = new GenericTreeNode<>(newPerson);
				currentEmployee.children.add(newE);
				nodes.add(newE);
				break;
			}
		}	
	}
		// add the newPerson as a direct report (child) of manager
	
	public void removeEmployee(Employee firedPerson){

	}
		// remove the employee, give their direct reports to their supervisor
	
	public void showOrgChartDepthFirst(){

	}
	
	public void showOrgChartBreadthFirst(){

	}
	
}
