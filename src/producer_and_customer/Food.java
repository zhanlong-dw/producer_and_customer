package producer_and_customer;

public class Food {
	private String name;
	private String des;
	private boolean flag = true; //true 代表可以生产  false代表可以消费
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public synchronized void setFood(String name,String des){
		if(!flag){
			try {
				this.wait();  //进入等待状态，不能生产
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.setName(name);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setDes(des);
		flag = false;  //表示可以消费了
		this.notify(); //唤醒当前线程
	}
	
	public String getDes() {
		return des;
	}
	
	public synchronized void getFood(){
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName()+":"+this.getDes());
		flag = true; //表示可以生产了
		this.notify(); //唤醒当前线程
	}
	
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "Food [name=" + name + ", des=" + des + "]";
	}
	public Food(String name, String des) {
		super();
		this.name = name;
		this.des = des;
	}
	public Food() {
		super();
	}
	
}
