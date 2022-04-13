package billing;

import java.time.Duration;

import money.Money;

public class RateDiscountableRegularPhone extends RegularPhone {
	private Money discountAmount;

	public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
		super(amount, seconds);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return fee.minus(discountAmount);
	}
}
