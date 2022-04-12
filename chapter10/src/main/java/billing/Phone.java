package billing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import money.Money;

public class Phone {
	private Money amount;
	private Duration seconds;
	private List<Call> calls = new ArrayList<>();

	public Phone(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	public Money calculateFee() {
		Money result = Money.ZERO;
		for (Call call : calls) {
			result = result.plus(calculateCallFee(call));
		}
		return result;
	}

	private Money calculateCallFee(Call call) {
		return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
