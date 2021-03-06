package billing;

import java.time.Duration;

import money.Money;

public class FixedFeePolicy extends BasicRatePolicy {
	private Money amount;
	private Duration seconds;

	public FixedFeePolicy(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
