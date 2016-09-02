package producer_and_customer;

/**
 * 消费者：服务员上菜
 * @author weixian
 *
 */
public class Customer implements Runnable{
	private Food food;
	
	public Customer(Food food){
		this.food=food;
	}
	@Override
	public void run() {
		for(int j=0;j<50;j++){
			food.getFood();
		}
	}

}
