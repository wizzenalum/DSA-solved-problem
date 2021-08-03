public class SavingsAccount
{
	private int balance;
	private double interest;

	public SavingsAccount(int initialBalance, double initialInterest)
	{
        this.balance = initialBalance;
        this.interest = initialInterest;
	}

	public void deposit(int amount)
	{
        this.balance+=amount;
	}

	public void withdraw(int amount)
	{
        this.balance -=amount;
	}

	public void addInterest()
	{
        this.balance +=this.balance*this.interest;
	}

	public int getBalance()
	{
		return this.balance;
	}

}