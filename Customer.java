package day4;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Customer {
	String customer_fname; 
	String customer_lname;
	String address; 
	String email;
	Connection con;
	PreparedStatement prest;
	CallableStatement cstat;
	ResultSet res;
	Statement st;
	
	public Customer(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root","Shubham@1998");
				System.out.println("Mysql conneceted");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	   
	}
	
public void Customerconnect() {
try {
	 cstat = con.prepareCall("create table Customer(customer_id int(20) NOT NULL AUTO_INCREMENT primary key,"
			+ "customer_fname varchar(20),"
			+ "customer_lname varchar(25),address varchar(100),email varchar(250))");  	  
	boolean result=cstat.execute();
	if(!result) {
		System.out.println("Table Created...");
		}
	else {
			System.out.println("Table not created...");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void  addCustomer() {
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter customer first name");
		customer_fname=sc.next();
		System.out.println("enter customer last name");
		customer_lname=sc.next();
		System.out.println("enter customer address");
		address=sc.next();
		System.out.println("enter customer email");
		email=sc.next();
		prest = con.prepareStatement("insert into Customer (customer_fname,customer_lname,address,email)values(?,?,?,?)");
		prest.setString(1,customer_fname);
		prest.setString(2,customer_lname);
		prest.setString(3,address);
		prest.setString(4,email);
		int in = prest.executeUpdate();
		if(in>0) 
		System.out.println("Customer inserted");
		else
		System.out.println("Customer not inserted");
		prest.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	

}
public void editCustomerDetails() {
	try{Scanner sc = new Scanner(System.in);
	System.out.println("enter customer first name");
	customer_fname=sc.next();
	System.out.println("enter customer last name");
	customer_lname=sc.next();
	System.out.println("enter customer address");
	address=sc.next();
	System.out.println("enter customer email");
	email=sc.next();
	prest=con.prepareStatement("update Customer set customer_fname=?,customer_lname=?,address=?,email=? where customer_id=1");
	 prest.setString(1,customer_fname );
	 prest.setString(2,customer_lname );
	 prest.setString(3,address );
	 prest.setString(4,email );
	 int in=prest.executeUpdate();
	 if(in>0)
		 System.out.println("Customer details updated");
		else
			System.out.println("Customer details not updated");
		prest.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void removeCustomer() {
	try {
		prest=con.prepareStatement("deleteCustomer from Customer where customer_id=?");
		 prest.setInt(5,2 );
		 int in=prest.executeUpdate();
		 if(in>0)
			 System.out.println("Customer deleted");
			else
				System.out.println("Customer not deleted");
			prest.close();
			}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void showCustomerDetails() {
	try {
		st=con.createStatement();
		res=st.executeQuery("select * from Customer");
		while(res.next()) {
			System.out.println("Id: " +res.getInt("customer_id"));
			System.out.println("First name: " +res.getString("customer_fname"));
			System.out.println("Last name: " +res.getString("customer_lname"));
			System.out.println("Address: " +res.getString("address"));
			System.out.println("Email: " +res.getString("email"));
			System.out.println(" ");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
