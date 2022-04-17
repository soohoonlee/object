package billing;

import java.util.List;

import time.DateTimeInterval;

public class FixedFeeCondition implements FeeCondition {
	@Override
	public List<DateTimeInterval> findTimeIntervals(Call call) {
		return List.of(call.getInterval());
	}
}
