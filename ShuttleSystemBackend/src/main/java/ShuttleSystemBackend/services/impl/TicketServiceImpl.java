package ShuttleSystemBackend.services.impl;

import ShuttleSystemBackend.domain.Ticket;
import ShuttleSystemBackend.repository.TicketRepository;
import ShuttleSystemBackend.services.Services;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2017/09/07.
 */
public class TicketServiceImpl implements Services<Ticket, Long> {
    @Autowired
    private TicketRepository repository;
    @Override
    public Ticket create(Ticket entity) {
        return repository.save(entity);
    }

    @Override
    public Ticket readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Ticket> readAll() {
        Iterable <Ticket> tickets = repository.findAll();
        Set<Ticket> ticketSet = new HashSet<>();

        for(Ticket ticket : tickets){
            ticketSet.add(ticket);
        }
        return ticketSet;
    }

    @Override
    public Ticket update(Ticket entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Ticket entity) {
        repository.delete(entity);
    }
}
