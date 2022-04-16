package billing;

import money.Money;

public class TaxablePolicy extends AdditionalRatePolicy {
	private double taxRatio;

	protected TaxablePolicy(RatePolicy next, double taxRatio) {
		super(next);
		this.taxRatio = taxRatio;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return fee.plus(fee.times(taxRatio));
	}
}
