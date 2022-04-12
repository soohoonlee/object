package billing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import money.Money;

public class Phone {
	private Money amount;
	private Duration seconds;
	private List<Call> calls = new ArrayList<>();
	private double taxRate;

	public Phone(Money amount, Duration seconds, double taxRate) {
		this.amount = amount;
		this.seconds = seconds;
		this.taxRate = taxRate;
	}

	public void call(Call call) {
		calls.add(call);
	}

	public Money getAmount() {
		return amount;
	}

	public Duration getSeconds() {
		return seconds;
	}

	public List<Call> getCalls() {
		return calls;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public Money calculateFee() {
		Money result = Money.ZERO;
		for (Call call : calls) {
			result = result.plus(amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds()));
		}
		return result.plus(result.times(taxRate));
	}
}
