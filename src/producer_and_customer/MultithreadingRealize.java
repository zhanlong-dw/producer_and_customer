package producer_and_customer;

public class MultithreadingRealize {

	public static void main(String[] args) {
		Food food = new Food();
		Product product = new Product( food );
		Customer customer = new Customer(food);
		new Thread(product).start();
		new Thread(customer).start();
	}

}
