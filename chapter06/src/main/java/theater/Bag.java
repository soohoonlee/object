package theater;

public class Bag {
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public boolean hasInvitation() {
		return invitation != null;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}
}
