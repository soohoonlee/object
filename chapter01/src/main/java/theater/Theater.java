package theater;

public class Theater {

	private TicketSeller ticketSeller;

	public Theater(final TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(final Audience audience) {
		ticketSeller.sellTo(audience);
	}
}
