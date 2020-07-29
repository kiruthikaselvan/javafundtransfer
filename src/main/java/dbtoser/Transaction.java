package dbtoser;

public class Transaction {

	private String tranid;
	private String state;
	private int balance;
	
	public Transaction(String tranid, String state, int balance) {
		this.tranid = tranid;
		this.state = state;
		this.balance = balance;
	}
	
	public String getTranid() {
		return tranid;
	}
	public void setTranid(String tranid) {
		this.tranid = tranid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
