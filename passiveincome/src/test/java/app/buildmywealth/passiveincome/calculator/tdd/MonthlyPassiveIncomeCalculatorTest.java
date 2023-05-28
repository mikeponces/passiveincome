package app.buildmywealth.passiveincome.calculator.tdd;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import app.buildmywealth.passiveincome.model.Investment;
import app.buildmywealth.passiveincome.model.PassiveIncomeSchedule;

public class MonthlyPassiveIncomeCalculatorTest {
	
	private static final LocalDate TODAY = LocalDate.of(2023, 5, 30);

	@Test
	public void sameMonth() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(60_000);
		
		LocalDate sameMonth = LocalDate.of(2023, 5, 1);
		Investment investment = new Investment("Government Bonds", sameMonth);
		
		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2023, 5, 1), BigDecimal.valueOf(30_000)), 
				new PassiveIncomeSchedule(LocalDate.of(2023, 5, 2), BigDecimal.valueOf(30_000)));
		
		CurrentDateSupplier currentDateSupplier = createMock(CurrentDateSupplier.class);
		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment, passiveIncomeSchedules);
		monthlyPassiveIncomeCalulator.setCurrentDateSupplier(currentDateSupplier);
		
		expect(currentDateSupplier.get()).andReturn(TODAY);
		replay(currentDateSupplier);
		
		BigDecimal actualMonthlyPassiveIncome = monthlyPassiveIncomeCalulator.calculate();
		
		
		assertEquals(expectedMonthlyPassiveIncome, actualMonthlyPassiveIncome);
		verify(currentDateSupplier);
	}
	
	@Test
	public void oneMonth() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(60_000);
		
		LocalDate oneMonthAgo = LocalDate.of(2023, 4, 1);
		Investment investment = new Investment("Stocks", oneMonthAgo);
		
		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2023, 4, 1), BigDecimal.valueOf(30_000)), 
				new PassiveIncomeSchedule(LocalDate.of(2023, 4, 2), BigDecimal.valueOf(30_000)));
		
		CurrentDateSupplier currentDateSupplier = createMock(CurrentDateSupplier.class);
		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment, passiveIncomeSchedules);
		monthlyPassiveIncomeCalulator.setCurrentDateSupplier(currentDateSupplier);
		
		expect(currentDateSupplier.get()).andReturn(TODAY);
		replay(currentDateSupplier);
		
		BigDecimal actualMonthlyPassiveIncome = monthlyPassiveIncomeCalulator.calculate();
		
		
		assertEquals(expectedMonthlyPassiveIncome, actualMonthlyPassiveIncome);
		verify(currentDateSupplier);
	}
	
	@Test
	public void sixMonths() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(10_000);
		
		LocalDate sixMonthsAgo = LocalDate.of(2022, 11, 1);
		Investment investment = new Investment("Pag-IBIG MP2", sixMonthsAgo);
		
		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2022, 11, 1), BigDecimal.valueOf(30_000)), 
				new PassiveIncomeSchedule(LocalDate.of(2022, 11, 2), BigDecimal.valueOf(30_000)));
		
		CurrentDateSupplier currentDateSupplier = createMock(CurrentDateSupplier.class);
		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment, passiveIncomeSchedules);
		monthlyPassiveIncomeCalulator.setCurrentDateSupplier(currentDateSupplier);
		
		expect(currentDateSupplier.get()).andReturn(TODAY);
		replay(currentDateSupplier);
		
		BigDecimal actualMonthlyPassiveIncome = monthlyPassiveIncomeCalulator.calculate();
		
		
		assertEquals(expectedMonthlyPassiveIncome, actualMonthlyPassiveIncome);
		verify(currentDateSupplier);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void incomeBeforeDateCreated() {
		LocalDate sameMonth = LocalDate.of(2023, 5, 1);
		Investment investment = new Investment("Corporate Bonds", sameMonth);
		
		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2023, 5, 1), BigDecimal.valueOf(30_000)), 
				new PassiveIncomeSchedule(LocalDate.of(2023, 4, 2), BigDecimal.valueOf(30_000)));
		
		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment, passiveIncomeSchedules);
		monthlyPassiveIncomeCalulator.calculate();
	}
	
	@Test
	public void excludeBrokersFee() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(15_000);
		
		Investment investment = new Investment("Condominium", LocalDate.of(2023, 3, 1));
		
		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2023, 4, 1), BigDecimal.valueOf(30_000), PassiveIncomeSchedule.BROKERS_FEE), 
				new PassiveIncomeSchedule(LocalDate.of(2023, 5, 1), BigDecimal.valueOf(30_000)));
		
		CurrentDateSupplier currentDateSupplier = createMock(CurrentDateSupplier.class);
		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment, passiveIncomeSchedules);
		monthlyPassiveIncomeCalulator.setCurrentDateSupplier(currentDateSupplier);
		
		expect(currentDateSupplier.get()).andReturn(TODAY);
		replay(currentDateSupplier);
		
		BigDecimal actualMonthlyPassiveIncome = monthlyPassiveIncomeCalulator.calculate();
		
		
		assertEquals(expectedMonthlyPassiveIncome, actualMonthlyPassiveIncome);
		verify(currentDateSupplier);
	}
}
