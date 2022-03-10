package theater;

public class TicketSeller {

	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	public void sellTo(final Audience audience) {
		ticketOffice.sellTicketTo(audience);
	}
}
