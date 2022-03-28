package movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
	private DiscountConditionType type;
	private int sequence;
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	public boolean isSatisfiedBy(Screening screening) {
		if (type == DiscountConditionType.PERIOD) {
			return isSatisfiedByPeriod(screening);
		}
		return isSatisfiedBySequence(screening);
	}

	private boolean isSatisfiedByPeriod(Screening screening) {
		return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&
				screening.getWhenScreened().toLocalTime().compareTo(startTime) >= 0 &&
				screening.getWhenScreened().toLocalTime().compareTo(endTime) <= 0;
	}

	private boolean isSatisfiedBySequence(Screening screening) {
		return sequence == screening.getSequence();
	}
}
