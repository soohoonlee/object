package movie;

import java.time.Duration;
import java.util.List;

import money.Money;

public class Movie {
	private String title;
	private Duration duration;
	private Money fee;
	private List<DiscountCondition> discountConditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	public Money calculateMovieFee(Screening screening) {
		if (isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}
		return fee;
	}

	private boolean isDiscountable(Screening screening) {
		return discountConditions.stream()
				.anyMatch(condition -> condition.isSatisfiedBy(screening));
	}

	private Money calculateDiscountAmount() {
		return switch (movieType) {
			case AMOUNT_DISCOUNT -> calculateAmountDiscountAmount();
			case PERCENT_DISCOUNT -> calculatePercentDiscountAmount();
			case NONE_DISCOUNT -> calculateNoneDiscountAmount();
		};
	}

	private Money calculateAmountDiscountAmount() {
		return discountAmount;
	}

	private Money calculatePercentDiscountAmount() {
		return fee.times(discountPercent);
	}

	private Money calculateNoneDiscountAmount() {
		return Money.ZERO;
	}
}
