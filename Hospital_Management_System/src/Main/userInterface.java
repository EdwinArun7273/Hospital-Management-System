package Main;

import java.util.Scanner;

public class userInterface {
    static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int ch1;
		
		do
		{
			System.out.print("\n\nHOSPITAL MANAGEMENT SYSTEM");
			System.out.print("\n\n\tLOGIN PAGE");
			System.out.print("\n\n1. Reception  Department");
			System.out.print("\n2. Doctor  Department");
			System.out.print("\n3. Billing  Department");
			System.out.print("\n4. Exit");
			System.out.print("\n\nEnter Your Choice: ");
			ch1 = sc.nextInt();
			switch(ch1)
			{
			case 1: reception();
					break;
			case 2: doctor();
					break;
			case 3: billing();
					break;
			case 4: System.out.print("\n\nThank You!");
					System.exit(0);
					break;
			default: System.out.print("\nINVALID INPUT");
	         		 break;
			}
		}while(ch1 != 4);
		sc.close();
	}
	
	public static void reception() 
	{
	    int ch2;
	    
	    do
	    {
	    	System.out.print("\n\n\tRECEPTION DEPARTMENT");
	    	System.out.print("\n\n1. Add Patient");
	    	System.out.print("\n2. View Patient");
	    	System.out.print("\n3. Add Appointment");
	    	System.out.print("\n4. Bed Allocation");
	    	System.out.print("\n5. Go Back To Login");
	    	System.out.print("\n\nEnter Your Choice: ");
	    	ch2 = sc.nextInt();
		
	    	switch(ch2)
	    	{
	    	case 1: Patient.addPatient();
					break;
			
	    	case 2: Patient.viewPatientDetails();
	    			break;
			
	    	case 3: Appointment.addtoList();
					break;
		
	    	case 4: bed.alloc();
					break;
			
	    	case 5: break;
		
	    	default: System.out.print("\nINVALID INPUT");
		         	break;
			
	    	}
	    }while(ch2!=5);
	}
	
	public static void doctor() 
	{
	    int ch3;
	    do
	    {
	    	System.out.print("\n\n\tDOCTOR DEPARTMENT");
	    	System.out.print("\n\n1. General Department");
	    	System.out.print("\n2. Pediatrician Department");
	    	System.out.print("\n3. Surgeon Department");
	    	System.out.print("\n4. Go Back To Login");
	    	System.out.print("\n\nEnter Your Choice: ");
	    	ch3 = sc.nextInt();
	    	switch(ch3)
	    	{
	    	case 1: general();
					break;
	    	case 2: pediatrician();
					break;
	    	case 3: surgeon();
					break;
	    	case 4: break;
	    	default: System.out.print("\nINVALID INPUT");
 		 		 	break;	
	    	}
	    }while(ch3!=4);
	}
	
	public static void general() 
	{
	    int ch4;	
	    
	    do
	    {
	    	System.out.print("\n\n\tDOCTOR: GENERAL  DEPARTMENT");
	    	System.out.print("\n\n1. Patient Queue");
	    	System.out.print("\n2. Go Back To Doctor Login");
	    	System.out.print("\n\nEnter Your Choice: ");
	    	ch4 = sc.nextInt();
	    	
	    	switch(ch4)
	    	{
	    	case 1: doctorDepartment.general();
	    			break;
	    			
	    	case 2: break;
		
	    	default: System.out.print("\nINVALID INPUT");
		         	break;	
	    	}
		}while(ch4!=2);
	}
	
	public static void pediatrician() 
	{
	    int ch5;	
	    
	    do
	    {
	    	System.out.print("\n\n\tDOCTOR PEDIATRICIAN DEPARTMENT");
	    	System.out.print("\n\n1. Patient Queue");
	    	System.out.print("\n2. Go Back To Doctor Login");
	    	System.out.print("\n\nEnter Your Choice: ");
	    	ch5 = sc.nextInt();
	    	
	    	switch(ch5)
	    	{
	    	case 1: doctorDepartment.pediatrician();
					break;
		
	    	default: System.out.print("\nINVALID INPUT");
	    			  break;
	    	}
	    }while(ch5!=2);
	}
	
	public static void surgeon() 
	{
	    int ch6;	
	    
	    do
	    {
	    	System.out.print("\n\n\tDOCTOR SURGEON DEPARTMENT");
	    	System.out.print("\n\n1. Patient Queue");
	    	System.out.print("\n2. Go Back To Doctor Login");
	    	System.out.print("\n\nEnter Your Choice: ");
	    	ch6 = sc.nextInt();
		
	    	switch(ch6)
	    	{
	    	case 1: doctorDepartment.surgeon();
	    			break;
		
	    	default: System.out.print("\nINVALID INPUT");
		         	break;
	    	}
		}while(ch6!=2);
	}
	
	public static void billing() 
	{
	    int ch7;	
	    
	    do
	    {
	    	System.out.print("\n\n\tBILLING LOGIN");
	    	System.out.print("\n\n1. Patient Billing");
	    	System.out.print("\n2. Go Back To Login");
	    	System.out.print("\n\nEnter Your Choice: ");
	    	ch7 = sc.nextInt();
	    	switch(ch7)
	    	{
	    	case 1: patientBilling.getBill();
					break;
		
	    	default: System.out.print("\nINVALID INPUT");
		         	break;
	    	}
	    }while(ch7!=2);
	}

}
