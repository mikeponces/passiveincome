package app.buildmywealth.passiveincome.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Investment {

	private String name;
	private LocalDate datePurchased;
	private BigDecimal monthlyPassiveIncome;

	public Investment(String name, LocalDate datePurchased) {
		super();
		this.name = name;
		this.datePurchased = datePurchased;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(LocalDate datePurchased) {
		this.datePurchased = datePurchased;
	}

	public BigDecimal getMonthlyPassiveIncome() {
		return monthlyPassiveIncome;
	}

	public void setMonthlyPassiveIncome(BigDecimal monthlyPassiveIncome) {
		this.monthlyPassiveIncome = monthlyPassiveIncome;
	}
}
