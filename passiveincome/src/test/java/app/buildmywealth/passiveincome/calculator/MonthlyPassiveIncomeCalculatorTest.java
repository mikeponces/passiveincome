package app.buildmywealth.passiveincome.calculator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

public class MonthlyPassiveIncomeCalculatorTest {
	
	@Test // TODO: DISCUSS ANNOTATION
	public void testMethod() {
		// TODO: DISCUSS TEST CASE COMPOSITION
		// 1. Provide expectation
		// 2. Setup test data
		// 3. Call your method
		// 4. Verify with assert statements
		
		// TODO: DISCUSS BASIC ANNOTATIONS
		// assertTrue, assertFalse
		// assertNull, assertNotNull
		// assertEquals, assertNotEquals
	}

	@Test
	public void sameMonth() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(60_000);
		
		BigDecimal totalPassiveIncome = BigDecimal.valueOf(60_000);
		LocalDate sameMonth = LocalDate.of(2023, 5, 1);
		
		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = new MonthlyPassiveIncomeCalculator(totalPassiveIncome, sameMonth);
		
		assertEquals(expectedMonthlyPassiveIncome, monthlyPassiveIncomeCalulator.calculate());
	}
	
	@Test
	public void oneMonth() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(60_000);
		
		BigDecimal totalPassiveIncome = BigDecimal.valueOf(60_000);
		LocalDate oneMonthAgo = LocalDate.of(2023, 4, 1);
		
		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = new MonthlyPassiveIncomeCalculator(totalPassiveIncome, oneMonthAgo);
		
		assertEquals(expectedMonthlyPassiveIncome, monthlyPassiveIncomeCalulator.calculate());
	}
	
	@Test
	public void sixMonths() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(10_000);
		
		BigDecimal totalPassiveIncome = BigDecimal.valueOf(60_000);
		LocalDate sixMonthsAgo = LocalDate.of(2022, 11, 1);
		
		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = new MonthlyPassiveIncomeCalculator(totalPassiveIncome, sixMonthsAgo);
		
		assertEquals(expectedMonthlyPassiveIncome, monthlyPassiveIncomeCalulator.calculate());
	}
}