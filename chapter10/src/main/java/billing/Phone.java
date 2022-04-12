package billing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import money.Money;

public class Phone extends AbstractPhone {
	private Money amount;
	private Duration seconds;

	public Phone(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
