package ShuttleSystemBackend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 2017/09/07.
 */
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String ticketType;
    private String route;
    private double cost;
    private Ticket(Ticket.TicketBuilder objBuilder)
    {
        this.id =objBuilder.id;
        this.ticketType=objBuilder.ticketType;
        this.route=objBuilder.route;
        this.cost=objBuilder.cost;
    }
    private Ticket(){}
    public Long getId() {
        return id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public String getRoute() {
        return route;
    }

    public double getCost() {
        return cost;
    }
    public static class TicketBuilder
    {
        private Long id;
        private  String ticketType;
        private String route;
        private double cost;
        public Ticket.TicketBuilder ticketId(Long id)
        {
            this.id =id;
            return this;
        }
        public Ticket.TicketBuilder ticketType(String ticketType)
        {
            this.ticketType=ticketType;
            return this;
        }
        public Ticket.TicketBuilder route(String route)
        {
            this.route=route;
            return this;
        }
        public Ticket.TicketBuilder cost(double cost)
        {
            this.cost=cost;
            return this;
        }
        public Ticket.TicketBuilder copy(Ticket objTicket)
        {
            this.id =objTicket.id;
            this.ticketType=objTicket.ticketType;
            this.route=objTicket.route;
            this.cost=objTicket.cost;
            return this;
        }
        public Ticket build()
        {
            return new Ticket(this);
        }
    }
    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
