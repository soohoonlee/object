package billing;

import java.util.List;

import time.DateTimeInterval;

public interface FeeCondition {
	List<DateTimeInterval> findTimeIntervals(Call call);
}
