package movie.pricing;

import money.Money;
import movie.DiscountCondition;
import movie.DefaultDiscountPolicy;
import movie.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
	private final Money discountAmount;

	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
