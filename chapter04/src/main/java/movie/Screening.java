package movie;

import java.time.LocalDateTime;

import money.Money;

public class Screening {

	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public LocalDateTime getWhenScreened() {
		return whenScreened;
	}

	public void setWhenScreened(LocalDateTime whenScreened) {
		this.whenScreened = whenScreened;
	}

	public Money calculateFee(int audienceCount) {
		switch (movie.getMovieType()) {
			case AMOUNT_DISCOUNT:
				if (movie.isDiscountable(whenScreened, sequence)) {
					return movie.calculateAmountDiscountedFee().times(audienceCount);
				}
				break;
			case PERCENT_DISCOUNT:
				if (movie.isDiscountable(whenScreened, sequence)) {
					return movie.calculatePercentDiscountedFee().times(audienceCount);
				}
				break;
			case NONE_DISCOUNT:
				return movie.calculateNoneDiscountedFee().times(audienceCount);
		}
		return movie.calculateNoneDiscountedFee().times(audienceCount);
	}
}
