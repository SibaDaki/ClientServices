package ShuttleSystemBackend.factory;

import ShuttleSystemBackend.domain.Ticket;

/**
 * Created by User on 2017/09/07.
 */
public class TicketFactory {

    public static Ticket createTicket(String type, String route, double cost)
    {
        return new Ticket.TicketBuilder()
                .ticketType(type)
                .route(route)
                .cost(cost)
                .build();
    }
}
