package cryptoSim;

import java.util.ArrayList;

public class ObservingPopulation implements Timer
{
	private int round = 0;
	private ArrayList<Observers> allMiners = new ArrayList<Observers>();
	
	/**
	 * Updates the round for all observers
	 */
	@Override
	public void roundUpdate() {
		//increments the round
		round++;
		for(int i = 0; i<allMiners.size(); i++)
		{
			allMiners.get(i).roundIncrement();
		}
	}

	/**
	 * adds a miner to the observers
	 */
	@Override
	public void addMiner(Observers miner) {
		allMiners.add(miner);	
	}
	
	/**
	 * removes a miner from the observers
	 */
	@Override
	public void removeMiner(Observers miner) {
		allMiners.remove(miner);	
	}

	/**
	 * gets the current round
	 * @return the current round
	 */
	public int getRound()
	{
		return round;
	}
	
	/**
	 * Gets the size of the observers array
	 */
	public int getObserverSize()
	{
		return allMiners.size();
	}


	
}
