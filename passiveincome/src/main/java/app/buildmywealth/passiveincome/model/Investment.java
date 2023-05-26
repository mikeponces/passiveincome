package app.buildmywealth.passiveincome.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Investment {

	private int id;
	private String name;
	private LocalDate purchaseDate;
	private BigDecimal monthlyPassiveIncome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public BigDecimal getMonthlyPassiveIncome() {
		return monthlyPassiveIncome;
	}
	public void setMonthlyPassiveIncome(BigDecimal monthlyPassiveIncome) {
		this.monthlyPassiveIncome = monthlyPassiveIncome;
	}
}
