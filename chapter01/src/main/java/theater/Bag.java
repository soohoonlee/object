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

	private boolean hasInvitation() {
		return invitation != null;
	}

	public boolean hasTicket() {
		return ticket != null;
	}

	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	private void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}

	public Long hold(Ticket ticket) {
		if (hasInvitation()) {
			setTicket(ticket);
			return 0L;
		} else {
			setTicket(ticket);
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}
}
