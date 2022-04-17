package billing;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import time.DateTimeInterval;

public class DayOfWeekFeeCondition implements FeeCondition {
	private List<DayOfWeek> dayOfWeeks;

	public DayOfWeekFeeCondition(DayOfWeek ... dayOfWeeks) {
		this.dayOfWeeks = Arrays.asList(dayOfWeeks);
	}

	@Override
	public List<DateTimeInterval> findTimeIntervals(Call call) {
		return call.splitByDay()
				.stream()
				.filter(dayOfWeek -> dayOfWeeks.contains(dayOfWeek.getFrom().getDayOfWeek()))
				.collect(Collectors.toList());
	}
}
