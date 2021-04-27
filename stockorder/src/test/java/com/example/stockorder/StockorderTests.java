package com.example.stockorder;

import org.junit.jupiter.api.*;

class StockorderTests {

	@Test
	void testCalculateTotalCost() {
		Stockorder s = new Stockorder();
		s.setAmount(100);
		s.setBuy(true);
		s.setStockId(1);
		s.setFee(1.5);
		
		Assertions.assertEquals(new Double(101.5), s.calculateTotalCost());

	}
}