package app.buildmywealth.passiveincome.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Investment {

	private String name;
	private LocalDate dateCreated;
	private BigDecimal monthlyPassiveIncome;
	
	public Investment(String name, LocalDate dateCreated) {
		super();
		this.name = name;
		this.dateCreated = dateCreated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public BigDecimal getMonthlyPassiveIncome() {
		return monthlyPassiveIncome;
	}
	public void setMonthlyPassiveIncome(BigDecimal monthlyPassiveIncome) {
		this.monthlyPassiveIncome = monthlyPassiveIncome;
	}
}
