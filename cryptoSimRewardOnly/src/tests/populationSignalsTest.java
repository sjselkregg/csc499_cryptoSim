package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cryptoSim.Observers;
import cryptoSim.ObservingPopulation;
import cryptoSim.Population;
import cryptoSim.Timer;

public class populationSignalsTest {

	
	/**
	 * Test to see if a population can be successfully created
	 */
	@Test
	public void testCreatePopulation()
	{
		Population pop = new Population(5);
		assertEquals(0, pop.getSizeNonActive());
		assertEquals(5, pop.getSizeActive());
		assertEquals(5, pop.getSizeTotal());
	}
	
	
	/**
	 * Tests to see if a population can be created, added to the observer array,
	 * then leave the array.
	 */
	@Test
	public void testSetup()
	{
		Timer t = new ObservingPopulation();
		assertEquals(0, ((ObservingPopulation) t).getRound());
		Observers s = new Population(5);
		t.addMiner(s);
		assertEquals(1, ((ObservingPopulation) t).getObserverSize());
		t.removeMiner(s);
		assertEquals(0, ((ObservingPopulation) t).getObserverSize());
	}
	
	
	/**
	 * Tests a round update
	 */
	@Test
	public void testUpdate()
	{
		Timer t = new ObservingPopulation();
		assertEquals(0, ((ObservingPopulation) t).getRound());
		Observers s = new Population(1);
		t.addMiner(s);
		t.roundUpdate();
		assertEquals(1, ((ObservingPopulation) t).getRound());
	}
	
	
	

}
