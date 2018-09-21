package cryptoSim;

import java.util.ArrayList;

public class Population implements Observers 
{
	private ArrayList<Miner> all = new ArrayList<Miner>();
	private ArrayList<Miner> active = new ArrayList<Miner>();
	private ArrayList<Miner> nonActive = new ArrayList<Miner>();
	
	/**
	 * Creates a population of miners based on the size.
	 * @param size (integer size of the population)
	 */
	public Population(int size)
	{
		for(int i = 0; i<size; i++)
		{
			int r = (int)(Math.random() * 100 + 1);
			all.add(new Miner(i, r));
			active.add(all.get(i));
		}
	}
	
	/**
	 * Gets the size of the population
	 */
	public int getSizeTotal()
	{
		return all.size();
	}
	
	/**
	 * Gets the size of participating population
	 */
	public int getSizeActive()
	{
		return active.size();
	}
	
	/**
	 * Gets the size of non participating population
	 */
	public int getSizeNonActive()
	{
		return nonActive.size();
	}
	
	/**
	 * Updates Active and nonActive lists
	 */
	public void updateLists() {
		for(int i = 0; i<active.size(); i++)
		{
			if(nonActive.get(i).getStatus() == false)
			{
				nonActive.add(active.get(i));
				active.remove(i);
			}
		}
		
		for(int i = 0; i<nonActive.size(); i++)
		{
			if(nonActive.get(i).getStatus() == false)
			{
				active.add(nonActive.get(i));
				nonActive.remove(i);
			}
		}
	}
	
	
	
	
	/**
	 * Implementation of roundIncrement method, gives a random miner
	 * rewards
	 */
	@Override
	public void roundIncrement()
	{
			int r = (int)(Math.random() * active.size());
			active.get(r).giveRewards();
			
			/**
			 * signals all miners that there has been a round change
			 */
			for(int i = 0; i<all.size(); i++)
			{
				all.get(i).roundChange();
			}
	}

	
	
}
