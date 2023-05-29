package app.buildmywealth.passiveincome.calculator.enhanced;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import app.buildmywealth.passiveincome.model.Investment;
import app.buildmywealth.passiveincome.model.PassiveIncomeSchedule;

public class MonthlyPassiveIncomeCalculatorTest {

	// TODO: DISCUSS TEST COVERAGE

	// TODO: DISCUSS ANNOTATIONS
	// 1. BeforeClass and AfterClass
	// 2. Before and After

	@BeforeClass
	public static void setUp() {
		// TODO: passiveIncomeSchedules
		System.out.println("setUp once");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("tearDown once");
	}

	@Before
	public void before() {
		System.out.println("Before each test");
	}

	@After
	public void after() {
		System.out.println("After each test");
	}

	@Test
	public void sameMonth() {
		BigDecimal expectedMonthlyPassiveIncome = BigDecimal.valueOf(60_000);

		LocalDate sameMonth = LocalDate.of(2023, 5, 1);
		Investment investment = new Investment("Government Bonds", sameMonth);

		List<PassiveIncomeSchedule> passiveIncomeSchedules = Stream
				.of(new PassiveIncomeSchedule(LocalDate.of(2023, 5, 1), BigDecimal.valueOf(30_000)),
						new PassiveIncomeSchedule(LocalDate.of(2023, 5, 2), BigDecimal.valueOf(30_000)))
				.collect(Collectors.toList());

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

		List<PassiveIncomeSchedule> passiveIncomeSchedules = Stream
				.of(new PassiveIncomeSchedule(LocalDate.of(2023, 4, 1), BigDecimal.valueOf(30_000)),
						new PassiveIncomeSchedule(LocalDate.of(2023, 4, 2), BigDecimal.valueOf(30_000)))
				.collect(Collectors.toList());

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

		List<PassiveIncomeSchedule> passiveIncomeSchedules = Stream
				.of(new PassiveIncomeSchedule(LocalDate.of(2022, 11, 1), BigDecimal.valueOf(30_000)),
						new PassiveIncomeSchedule(LocalDate.of(2022, 11, 2), BigDecimal.valueOf(30_000)))
				.collect(Collectors.toList());

		MonthlyPassiveIncomeCalculator monthlyPassiveIncomeCalulator = MonthlyPassiveIncomeCalculator.of(investment,
				passiveIncomeSchedules);
		BigDecimal actualMonthlyPassiveIncome = monthlyPassiveIncomeCalulator.calculate();

		assertEquals(expectedMonthlyPassiveIncome, actualMonthlyPassiveIncome);
	}
}
