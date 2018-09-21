package cryptoSim;

public interface Timer {
	
	/**
	 * Adds observers to receive signals
	 * @param miner
	 */
	public void addMiner(Observers miner);
	
	/**
	 * removes a miner from the signals list
	 * @param miner
	 */
	public void removeMiner(Observers miner);
	
	/**
	 * updates the round, sends signals
	 */
	public void roundUpdate();
}
