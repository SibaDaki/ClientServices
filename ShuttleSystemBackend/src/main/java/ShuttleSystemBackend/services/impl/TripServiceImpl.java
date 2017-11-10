package ShuttleSystemBackend.services.impl;

import ShuttleSystemBackend.repository.TripRepository;
import ShuttleSystemBackend.domain.TripDetails;
import ShuttleSystemBackend.services.Services;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2017/09/07.
 */
@Entity
public class TripServiceImpl implements Services<TripDetails,Long> {

    @Autowired
    private TripRepository repository;
    @Override
    public TripDetails create(TripDetails entity) {
        return repository.save(entity);
    }

    @Override
    public TripDetails readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<TripDetails> readAll() {
        Iterable <TripDetails> tripDetails = repository.findAll();
        Set<TripDetails> ticketSet = new HashSet<>();

        for(TripDetails tripDetailss : tripDetails){
            ticketSet.add(tripDetailss);
        }
        return ticketSet;
    }

    @Override
    public TripDetails update(TripDetails entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(TripDetails entity) {
        repository.delete(entity);
    }
}

