package billing;

import java.util.ArrayList;
import java.util.List;

import money.Money;
import time.DateTimeInterval;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy {
	private List<DayOfWeekDiscountRule> rules;

	public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> rules) {
		this.rules = rules;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		Money result = Money.ZERO;
		for (DateTimeInterval interval : call.getInterval().splitByDay()) {
			for (DayOfWeekDiscountRule rule : rules) {
				result.plus(rule.calculate(interval));
			}
		}
		return result;
	}
}
