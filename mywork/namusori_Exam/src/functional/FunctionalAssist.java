package functional;

import java.util.ArrayList;
import java.util.List;

public class FunctionalAssist {
	
	public static void main(String[] args) {
		CustomerService service = new CustomerService();
		initData(service);
		
		List<Customer> result = new ArrayList<>();
		
		result = service.searchCustomers(new SearchFilter() {
			
			@Override
			public boolean inMatched(Customer customer) {
				if(customer.getLocation().equals("Seoul") && customer.getAge() > 30)
					return true;
			
				else
					return false;
			}
			
		});

		for(Customer customer : result) {
			System.out.println(customer);
		}
	}
	
	private static void initData(CustomerService service) {
		service.addCustomer(new Customer("CUS01", "Seoul", Gender.Male, 30));
		service.addCustomer(new Customer("CUS02", "Busan", Gender.Female, 55));
		service.addCustomer(new Customer("CUS03", "Seoul", Gender.Female, 13));
		service.addCustomer(new Customer("CUS04", "Gwangju", Gender.Male, 27));
		service.addCustomer(new Customer("CUS05", "Gwangju", Gender.Female, 61));
		service.addCustomer(new Customer("CUS06", "Incheon", Gender.Male, 29));
		service.addCustomer(new Customer("CUS07", "Seoul", Gender.Male, 42));
		service.addCustomer(new Customer("CUS08", "Seoul", Gender.Female, 45));
		service.addCustomer(new Customer("CUS09", "Seoul", Gender.Female, 33));
		service.addCustomer(new Customer("CUS10", "Busan", Gender.Male, 20));
		
		
	}

}
