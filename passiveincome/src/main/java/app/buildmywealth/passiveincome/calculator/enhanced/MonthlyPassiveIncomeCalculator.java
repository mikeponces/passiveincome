package app.buildmywealth.passiveincome.calculator.enhanced;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import app.buildmywealth.passiveincome.model.Investment;
import app.buildmywealth.passiveincome.model.PassiveIncomeSchedule;

public class MonthlyPassiveIncomeCalculator {

	private BigDecimal totalPassiveIncome;
	private LocalDate startDate;

	private MonthlyPassiveIncomeCalculator(BigDecimal totalPassiveIncome, LocalDate startDate) {
		this.totalPassiveIncome = totalPassiveIncome;
		this.startDate = startDate;
	}
	
	public static MonthlyPassiveIncomeCalculator of(Investment investment, Stream<PassiveIncomeSchedule> passiveIncomeSchedules) {
		BigDecimal totalPassiveIncome = passiveIncomeSchedules
				.map(PassiveIncomeSchedule::getAmount)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		LocalDate startDate = investment.getDateCreated();
		
		return new MonthlyPassiveIncomeCalculator(totalPassiveIncome, startDate);
	}

	public BigDecimal calculate() {
		long monthsExisting = ChronoUnit.MONTHS.between(startDate, LocalDate.now());

		if (monthsExisting == 0) {
			monthsExisting = 1;
		}
		
		return totalPassiveIncome.divide(BigDecimal.valueOf(monthsExisting));
	}
}
