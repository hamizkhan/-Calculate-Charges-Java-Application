//Hamiz Khan INSY 4306 Section 002

import java.io.*;
public class ReadCustomers
{
	public static void main(String[] args)
	{
	
		ObjectInputStream input;
		MavRental mavRead;
		
		try
		{
			input=new ObjectInputStream (new FileInputStream("customers.ser"));
			
			while(true)
			{
				mavRead=(MavRental)input.readObject();
			
				for(Customer c:mavRead.getCustomerList())
				{
					System.out.println(c.toString());
				}
				
				System.out.println(mavRead);
			}
			
		}
		
		catch(EOFException eofe)
		{
			System.exit(0);
		}
		
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Class not found");
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
	}
	

}
