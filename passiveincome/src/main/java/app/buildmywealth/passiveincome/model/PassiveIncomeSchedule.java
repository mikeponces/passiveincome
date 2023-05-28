package app.buildmywealth.passiveincome.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PassiveIncomeSchedule {
	public static final String BROKERS_FEE = "Broker's Fee";
	private int investmentId;
	private String description;
	private LocalDate dateReceived;
	private BigDecimal amount;
	
	public PassiveIncomeSchedule(LocalDate dateReceived, BigDecimal amount) {
		this(dateReceived, amount, "");
	}
	public PassiveIncomeSchedule(LocalDate dateReceived, BigDecimal amount, String description) {
		super();
		this.dateReceived = dateReceived;
		this.amount = amount;
		this.description = description;
	}
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public boolean isBrokersFee() {
		return BROKERS_FEE.equals(description);
	}
}
