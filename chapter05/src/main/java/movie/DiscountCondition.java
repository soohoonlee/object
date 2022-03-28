package movie;

public class DiscountCondition {
	private final PeriodCondition periodCondition = new PeriodCondition(this);
	private DiscountConditionType type;
	private int sequence;

	public boolean isSatisfiedBy(Screening screening) {
		if (type == DiscountConditionType.PERIOD) {
			return periodCondition.isSatisfiedBy(screening);
		}
		return isSatisfiedBySequence(screening);
	}

	private boolean isSatisfiedBySequence(Screening screening) {
		return sequence == screening.getSequence();
	}
}
