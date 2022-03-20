package movie;

import java.util.Arrays;
import java.util.List;

import money.Money;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
	private final List<DiscountCondition> conditions;

	protected DefaultDiscountPolicy(DiscountCondition... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	public Money calculateDiscountAmount(Screening screening) {
		for (DiscountCondition condition : conditions) {
			if (condition.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}
		return Money.ZERO;
	}

	protected abstract Money getDiscountAmount(Screening screening);
}
