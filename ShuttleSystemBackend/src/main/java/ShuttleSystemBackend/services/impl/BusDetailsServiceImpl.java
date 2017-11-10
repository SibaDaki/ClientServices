package ShuttleSystemBackend.services.impl;

import ShuttleSystemBackend.domain.BusDetails;
import ShuttleSystemBackend.repository.BusDetailsRepository;
import ShuttleSystemBackend.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2017/09/07.
 */

@Service
public class BusDetailsServiceImpl implements Services<BusDetails,Long> {
@Autowired
private BusDetailsRepository repository;
@Override
public BusDetails create(BusDetails entity) {
        return repository.save(entity);
        }

@Override
public BusDetails readById(Long id) {
        return repository.findOne(id);
        }

@Override
public Set<BusDetails> readAll() {
        Iterable<BusDetails> buses = repository.findAll();
        Set busSet = new HashSet();
        for(BusDetails busDetails : buses) {
        busSet.add(busDetails);
        }
        return busSet;
        }

@Override
public BusDetails update(BusDetails entity) {
        return repository.save(entity);
        }

@Override
public void delete(BusDetails entity) {
        repository.delete(entity);
        }
        }
