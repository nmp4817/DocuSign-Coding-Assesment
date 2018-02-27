package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.Rules;

/**
 * Testing Methods of Rule class.
 * @author Nabil
 *
 */
class RulesTest {
	
	/**
	 * Tests isPajamaOff() Method when Pajama is not removed.
	 */
	@Test
	void testIsPajamaOff_False() {
		Rules.results =  new ArrayList<ArrayList<String>>();
		Rules.result = new ArrayList<String>();
		Rules.inputList = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add("6");}};
		
		assertFalse(Rules.isPajamaOff());
	}
	
	/**
	 * Tests isPajamaOff() Method when Pajama is removed.
	 */
	@Test
	void testIsPajamaOff_True() {
		Rules.result = new ArrayList<String>();
		Rules.inputList = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add("8");}};
		
		assertTrue(Rules.isPajamaOff());
	}
	
	/**
	 * Tests isSocksOn() Method when Socks are not On.
	 */
	@Test
	void testIsSocksOn_False() {
		Rules.result = new ArrayList<String>();
		Rules.inputList = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add("8"); add("2"); add("1");}};
		
		assertFalse(Rules.isSocksOn());
	}

	@Test
	void testIsSocksOn_True() {
		Rules.result = new ArrayList<String>();
		Rules.inputList = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add("8"); add("2"); add("3");}};
		
		assertTrue(Rules.isSocksOn());
	}
	
	/**
	 * Tests isSocksOn() Method when Socks are On.
	 */
	@Test
	void testIsJacketOn_False() {
		Rules.result = new ArrayList<String>();
		Rules.inputList = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add("8"); add("2"); add("1");}};
		
		assertFalse(Rules.isJacketOn());
	}
	
	/**
	 * Tests isJacketOn() Method when Jacket is On.
	 */
	@Test
	void testIsJacketOn_True() {
		Rules.result = new ArrayList<String>();
		Rules.inputList = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add("8"); add("2"); add("5");}};
		
		assertTrue(Rules.isJacketOn());
	}
}
