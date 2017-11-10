package ShuttleSystemBackend.services.impl;

import ShuttleSystemBackend.domain.Passenger;
import ShuttleSystemBackend.repository.PassengerRepository;
import ShuttleSystemBackend.services.Services;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2017/09/07.
 */
public class PassangerServiceImpl implements Services<Passenger,Long> {
    @Autowired
    private PassengerRepository repository;

    @Override
    public Passenger create(Passenger entity) {
        return repository.save(entity);
    }

    @Override
    public Passenger readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Passenger> readAll() {
        Iterable<Passenger> passengers = repository.findAll();
        Set<Passenger> passengerSet = new HashSet<>();

        for (Passenger passenger : passengers){
            passengerSet.add(passenger);
        }
        return passengerSet;
    }

    @Override
    public Passenger update(Passenger entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Passenger entity) {
        repository.delete(entity);
    }
}
