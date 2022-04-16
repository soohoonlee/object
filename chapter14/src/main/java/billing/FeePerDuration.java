package billing;

import java.time.Duration;

import money.Money;
import time.DateTimeInterval;

public class FeePerDuration {
	private Money fee;
	private Duration duration;

	public FeePerDuration(Money fee, Duration duration) {
		this.fee = fee;
		this.duration = duration;
	}

	public Money calculate(DateTimeInterval interval) {
		return fee.times((double) interval.duration().getSeconds() / duration.getSeconds());
	}
}
