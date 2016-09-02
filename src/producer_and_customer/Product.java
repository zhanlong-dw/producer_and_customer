package producer_and_customer;

/**
 * 生产者:厨师做菜
 * @author weixian
 *
 */
public class Product implements Runnable {
	private Food food;
	
	public Product(Food food){
		this.food=food;
	}

	@Override
	public void run() {
		for(int i=0;i<50;i++){
			if(i%2==0){
				food.setFood("辣椒炒肉","很辣很好吃！");
			}else{
				food.setFood("臭豆腐","很臭很好吃！");
			}
		}
	}

}
