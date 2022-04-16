package billing;

import money.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {
	private Money discountAmount;

	protected RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
		super(next);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return fee.minus(discountAmount);
	}
}
