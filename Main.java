package day4;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Customer c = new Customer();
		//c.Customerconnect();
		while(true) {
		System.out.println("1:AddCustomer\n2:EditDetails\n3:RemoveCustomer\n4:PrintDetails\n5:Exit Application");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		switch(i)
		{
		case 1:c.addCustomer();
		         break;
		case 2:c.editCustomerDetails();
				break;
		case 3:c.removeCustomer();
				break;
		case 4:c.showCustomerDetails();
				break;
		case 5: System.exit(5);
				break;
		default:System.out.println("Please choose valid option");
		}
		}
     //c.addCustomer();
     //c.editCustomerDetails();
	}

}










