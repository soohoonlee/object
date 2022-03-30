package movie;

import java.time.Duration;

import money.Money;

public class NoneDiscountMovie extends Movie {
	public NoneDiscountMovie(String title, Duration runningTime, Money fee) {
		super(title, runningTime, fee);
	}

	@Override
	protected Money calculateDiscountAmount() {
		return Money.ZERO;
	}
}
