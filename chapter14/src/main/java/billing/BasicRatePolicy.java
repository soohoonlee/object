package billing;

import java.util.Arrays;
import java.util.List;

import money.Money;

public class BasicRatePolicy implements RatePolicy {
	private List<FeeRule> feeRules;

	public BasicRatePolicy(FeeRule... feeRules) {
		this.feeRules = Arrays.asList(feeRules);
	}

	@Override
	public Money calculateFee(Phone phone) {
		return phone.getCalls()
				.stream()
				.map(this::calculate)
				.reduce(Money.ZERO, Money::plus);
	}

	private Money calculate(Call call) {
		return feeRules
				.stream()
				.map(rule -> rule.calculateFee(call))
				.reduce(Money.ZERO, Money::plus);
	}

}
