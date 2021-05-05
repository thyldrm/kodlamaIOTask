package interfaceAbstract;

import java.time.LocalDate;

import abstractt.BaseCustomerManager;
import adapters.MernisServiceAdapter;
import concrete.NeroCustomerManager;
import concrete.StarbucksCustomerManager;
import entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager=new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.save(new Customer(1,"Taha","Yýldýrým",LocalDate.of(1996,1,1),"12345678910"));
		
	
		
	}

}
