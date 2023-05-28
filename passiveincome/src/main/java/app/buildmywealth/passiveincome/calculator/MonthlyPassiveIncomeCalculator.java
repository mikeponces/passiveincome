package app.buildmywealth.passiveincome.calculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MonthlyPassiveIncomeCalculator {

	private BigDecimal totalPassiveIncome;
	private LocalDate startDate;

	public MonthlyPassiveIncomeCalculator(BigDecimal totalPassiveIncome, LocalDate startDate) {
		this.totalPassiveIncome = totalPassiveIncome;
		this.startDate = startDate;
	}

	public BigDecimal calculate() {
		long monthsExisting = ChronoUnit.MONTHS.between(startDate, LocalDate.now());

		if (monthsExisting == 0) {
			monthsExisting = 1;
		}

		return totalPassiveIncome.divide(BigDecimal.valueOf(monthsExisting));
	}
}
