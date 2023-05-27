package app.buildmywealth.passiveincome.calculator.tdd;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import app.buildmywealth.passiveincome.model.Investment;
import app.buildmywealth.passiveincome.model.PassiveIncomeSchedule;

public class MonthlyPassiveIncomeCalculator {

	private BigDecimal totalPassiveIncome;
	private LocalDate startDate;
	private CurrentDateSupplier currentDateSupplier;

	private MonthlyPassiveIncomeCalculator(BigDecimal totalPassiveIncome, LocalDate startDate) {
		this.totalPassiveIncome = totalPassiveIncome;
		this.startDate = startDate;
		this.currentDateSupplier = new CurrentDateSupplier();
	}

	public static MonthlyPassiveIncomeCalculator of(Investment investment,
			Collection<PassiveIncomeSchedule> passiveIncomeSchedules) {
		LocalDate startDate = investment.getDateCreated();

		if (passiveIncomeSchedules.stream()
				.anyMatch((passiveIncomeSchedule) -> passiveIncomeSchedule.getDateReceived().isBefore(startDate))) {
			throw new IllegalArgumentException("Invalid Passive Income Schedule");
		}

		BigDecimal totalPassiveIncome = passiveIncomeSchedules.stream()
				.filter((passiveIncomeSchedule) -> !passiveIncomeSchedule.isBrokersFee())
				.map(PassiveIncomeSchedule::getAmount)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		return new MonthlyPassiveIncomeCalculator(totalPassiveIncome, startDate);
	}

	public BigDecimal calculate() {
		long monthsExisting = ChronoUnit.MONTHS.between(startDate, currentDateSupplier.get());

		if (monthsExisting == 0) {
			monthsExisting = 1;
		}

		return totalPassiveIncome.divide(BigDecimal.valueOf(monthsExisting));
	}

	public void setCurrentDateSupplier(CurrentDateSupplier currentDateSupplier) {
		this.currentDateSupplier = currentDateSupplier;
	}
}
