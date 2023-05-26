package app.buildmywealth.passiveincome.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PassiveIncomeSchedule {
	private int id;
	private int investmentId;
	private LocalDate dateReceived;
	private BigDecimal amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	public LocalDate getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(LocalDate dateReceived) {
		this.dateReceived = dateReceived;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
