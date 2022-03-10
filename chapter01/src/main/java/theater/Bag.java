package theater;

public class Bag {

	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public Bag(final Long amount) {
		this(amount, null);
	}

	public Bag(final Long amount, final Invitation invitation) {
		this.amount = amount;
		this.invitation = invitation;
	}

	public boolean hasInvitation() {
		return invitation != null;
	}

	public boolean hasTicket() {
		return ticket != null;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}
}
