package billing;

import java.util.ArrayList;
import java.util.List;

import money.Money;

public abstract class Phone {
	private List<Call> calls = new ArrayList<>();

	public Money calculateFee() {
		Money result = Money.ZERO;
		for (Call call : calls) {
			result = result.plus(calculateCallFee(call));
		}
		return result;
	}

	protected abstract Money calculateCallFee(Call call);
}
