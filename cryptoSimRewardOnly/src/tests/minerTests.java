package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cryptoSim.Miner;

public class minerTests {

	/**
	 * Checks functionality of miner operations
	 */
	@Test
	public void testMinerOps()
	{
		Miner rocky = new Miner(1, 100);
		assertTrue(rocky.getStatus());
		rocky.leave();
		assertFalse(rocky.getStatus());
		rocky.join();
		
		//can a miner expend resources to mine?
		rocky.attemptMine();
		assertEquals(99, rocky.getWealth());
		
		//can a miner recieve rewards?
		rocky.giveRewards();
		assertEquals(109, rocky.getWealth());
		
		//can a miner react to a round change?
		rocky.roundChange();
		assertEquals(108, rocky.getWealth());
	}

}
