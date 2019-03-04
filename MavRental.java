//Hamiz Khan INSY 4306 Section 002

import java.io.Serializable;
import java.util.*;

public class MavRental implements Invoice,Serializable
{
	private ArrayList<Customer> customerList=new ArrayList<Customer>();

	public MavRental()
	{
		setCustomerList(new ArrayList<Customer>());
	}
	public MavRental(ArrayList<Customer> customerList) 
	{
		setCustomerList(customerList);
	}
	
	public void setCustomerList(ArrayList<Customer> customerList)
	{
		this.customerList=customerList;
	}
	
	public ArrayList<Customer> getCustomerList()
	{
		return customerList;
	}
	
	public void addCustomer(Customer c)
	{
		customerList.add(c);
	}
	
	public boolean customerExists(String name)
	{
		
		String n;
				for(Customer c:customerList)
				{
					n=c.getName();
					if(n.equals(name))
						return true;
				}
				
				return false;
	}
	
	@Override
	public String printInvoice()
	{
		double total;
		String msg="";
		
		for(Customer c:customerList)
		{
			total=0.0;
			for(Rental r:c.getRentalList())
				total+=r.calculateCharge();
		
			msg+= (String.format("%s: \t $%.2f\n", c.getName(),total));
		
		}
		return msg;
			
	}
	
	@Override
	public String toString()
	{
		return "Customer List: " + customerList;
	}
	
	
	
	
	
	
}
