package ShuttleSystemBackend.repository;

import ShuttleSystemBackend.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by User on 2017/09/07.
 */
public interface TicketRepository extends CrudRepository<Ticket,Long> {
}
