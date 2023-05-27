package app.buildmywealth.passiveincome.calculator.tdd;

import java.time.LocalDate;
import java.util.function.Supplier;

public class CurrentDateSupplier implements Supplier<LocalDate> {

	@Override
	public LocalDate get() {
		return LocalDate.now();
	}

}
