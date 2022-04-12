package billing;

import java.time.Duration;

import money.Money;

public class RegularPhone extends Phone {
	private Money amount;
	private Duration seconds;

	public RegularPhone(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
