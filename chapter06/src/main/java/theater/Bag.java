package theater;

public class Bag {
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public boolean hasInvitation() {
		return invitation != null;
	}

	public Long setTicket(Ticket ticket) {
		if (hasInvitation()) {
			this.ticket = ticket;
			return 0L;
		}
		else {
			this.ticket = ticket;
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}
}
