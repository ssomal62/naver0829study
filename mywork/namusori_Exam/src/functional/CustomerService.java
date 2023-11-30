package functional;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	private List<Customer> customers;
	
	public CustomerService() {this.customers = new ArrayList<>();}
	
	public void addCustomer(Customer newCustomer) { this.customers.add(newCustomer);}
	
	//지역 검색 구현
		
//	public List<Customer> serchCustomerByLocation(String location){
//		List<Customer> foundCustomers = new ArrayList<>();
//		
//		for(Customer customer : customers) {
//			if(customer.getLocation().equals(location)) {
//				foundCustomers.add(customer);
//			}
//		}
//		return foundCustomers;
//	}
	
	//성별 검색 구현
	
//	public List<Customer> serchCustomerByGender(Gender gender){
//		List<Customer> foundCustomers = new ArrayList<>();
//		for(Customer customer : customers) {
//			if(customer.getGender().equals(gender)) {
//				foundCustomers.add(customer);
//			}
//		}
//		
//		return foundCustomers;
//	}
	
	
	//인터페이스를 통한 검새 메소드
	
	public List<Customer> searchCustomers(SearchFilter filter){
		List<Customer> foundCustomers = new ArrayList<>();
		
		for(Customer customer : customers) {
			if(filter.inMatched(customer)) {
				foundCustomers.add(customer);
			}
		}
		return foundCustomers;
	}
}
