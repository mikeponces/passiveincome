package app.buildmywealth.passiveincome.calculator.exception;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import app.buildmywealth.passiveincome.model.Investment;
import app.buildmywealth.passiveincome.model.PassiveIncomeSchedule;

public class MonthlyPassiveIncomeCalculatorTest {

	// TODO: Run Test Coverage before
	// TODO: Add @Test(expect)
	// TODO: Run Test Coverage after

	@Test
	public void sameMonth() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(60_000);

		LocalDate sameMonth = LocalDate.of(2023, 5, 1);
		Investment investment = new Investment("Government Bonds", sameMonth);

		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2023, 5, 1), BigDecimal.valueOf(30_000)),
				new PassiveIncomeSchedule(LocalDate.of(2023, 5, 2), BigDecimal.valueOf(30_000)));

		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment,
				passiveIncomeSchedules);
		BigDecimal actualMonthlyPassiveIncome = monthlyPassiveIncomeCalulator.calculate();

		assertEquals(expectedMonthlyPassiveIncome, actualMonthlyPassiveIncome);
	}

	@Test
	public void oneMonth() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(60_000);

		LocalDate oneMonthAgo = LocalDate.of(2023, 4, 1);
		Investment investment = new Investment("Stocks", oneMonthAgo);

		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2023, 4, 1), BigDecimal.valueOf(30_000)),
				new PassiveIncomeSchedule(LocalDate.of(2023, 4, 2), BigDecimal.valueOf(30_000)));

		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment,
				passiveIncomeSchedules);
		BigDecimal actualMonthlyPassiveIncome = monthlyPassiveIncomeCalulator.calculate();

		assertEquals(expectedMonthlyPassiveIncome, actualMonthlyPassiveIncome);
	}

	@Test
	public void sixMonths() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(10_000);

		LocalDate sixMonthsAgo = LocalDate.of(2022, 11, 1);
		Investment investment = new Investment("Pag-IBIG MP2", sixMonthsAgo);

		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2022, 11, 1), BigDecimal.valueOf(30_000)),
				new PassiveIncomeSchedule(LocalDate.of(2022, 11, 2), BigDecimal.valueOf(30_000)));

		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment,
				passiveIncomeSchedules);
		BigDecimal actualMonthlyPassiveIncome = monthlyPassiveIncomeCalulator.calculate();

		assertEquals(expectedMonthlyPassiveIncome, actualMonthlyPassiveIncome);
	}

	@Test(expected = IllegalArgumentException.class)
	public void incomeBeforeDateCreated() {
		LocalDate sameMonth = LocalDate.of(2023, 5, 1);
		Investment investment = new Investment("Corporate Bonds", sameMonth);

		List<PassiveIncomeSchedule> passiveIncomeSchedules = List.of(
				new PassiveIncomeSchedule(LocalDate.of(2023, 5, 1), BigDecimal.valueOf(30_000)),
				new PassiveIncomeSchedule(LocalDate.of(2023, 4, 2), BigDecimal.valueOf(30_000)));

		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment,
				passiveIncomeSchedules);
		monthlyPassiveIncomeCalulator.calculate();
	}
}
