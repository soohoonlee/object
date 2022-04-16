package billing;

import money.Money;

public interface RatePolicy {
	Money calculateFee(Phone phone);
}
