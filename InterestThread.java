package bank;

public class InterestThread implements Runnable{
	    Account account;
	    public InterestThread(Account account) {
	        this.account =account;
	    }
	    @Override
	    public void run() {
	        // TODO Auto-generated method stub
	        while(true) {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            account.interest();
	        }
	    }
	     
	}
