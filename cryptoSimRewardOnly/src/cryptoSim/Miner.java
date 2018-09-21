package cryptoSim;

public class Miner
{
	private float sensitivity; 
	private int coinsOwned; //0-100
	private int prevCoins;
	private int startCoins;
	private int cost = 1; //miners cost to mine
	private int minerID;
	private boolean active = true;
	
	/**
	 * Initializes the miner
	 * @param ID Miner identification number
	 * @param cO Coins owned by this miner
	 */
	public Miner(int ID, int cO)
	{
		minerID = ID;
		coinsOwned = cO;
		startCoins = cO;
		sensitivity = (float)(coinsOwned/100);
	}
	
	/**
	 * joins the network
	 */
	public void join()
	{
		active = true;
	}
	
	/**
	 * leaves the network
	 */
	public void leave()
	{
		active = false;
	}
	
	/**
	 * Everybody who mines will have to pay the cost to mine
	 */
	public void attemptMine()
	{
		prevCoins = coinsOwned;
		coinsOwned = coinsOwned - cost;
		//only one persons miner ID will win
	}

	/**
	 * Gives rewards to a winning miner
	 */
	public void giveRewards() {
		prevCoins = coinsOwned;
		coinsOwned = coinsOwned + 10;
		
	}
	
	/**
	 * Gets the status of the miner
	 * @return active (the miners activity status)
	 */
	public boolean getStatus(){
		return active;
	}
	
	/**
	 * An individual miners behavior during a round update
	 */
	public void roundChange()
	{
		if(active == true)
		{
			attemptMine();
		}else
		{
		     
		}
	}
	
	
	public int getWealth()
	{
		return coinsOwned;
	}
	
}
