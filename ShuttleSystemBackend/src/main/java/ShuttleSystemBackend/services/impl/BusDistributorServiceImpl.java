package ShuttleSystemBackend.services.impl;

import ShuttleSystemBackend.domain.BusDistributor;
import ShuttleSystemBackend.repository.BusDistributorRepository;
import ShuttleSystemBackend.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2017/09/07.
 */
@Service
public class BusDistributorServiceImpl implements Services<BusDistributor,Long> {
    @Autowired
    private BusDistributorRepository repository;
    @Override
    public BusDistributor create(BusDistributor entity) {
        return repository.save(entity) ;
    }

    @Override
    public BusDistributor readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<BusDistributor> readAll() {
        Iterable<BusDistributor> suppliers =repository.findAll();
        Set supplierSet = new HashSet();
        for(BusDistributor supplier:suppliers){
            supplierSet.add(supplier);
        }
        return supplierSet;
    }

    @Override
    public BusDistributor update(BusDistributor entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(BusDistributor entity) {
        repository.delete(entity);
    }
}
