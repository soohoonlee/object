package movie.pricing;

import money.Money;
import movie.DiscountCondition;
import movie.DefaultDiscountPolicy;
import movie.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
	private final double percent;

	public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.getMovieFee().times(percent);
	}
}
