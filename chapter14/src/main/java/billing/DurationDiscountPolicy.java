package billing;

import java.util.List;

import money.Money;

public class DurationDiscountPolicy extends BasicRatePolicy {
	private List<DurationDiscountRule> rules;

	public DurationDiscountPolicy(List<DurationDiscountRule> rules) {
		this.rules = rules;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		Money result = Money.ZERO;
		for (DurationDiscountRule rule : rules) {
			result.plus(rule.calculate(call));
		}
		return result;
	}
}
