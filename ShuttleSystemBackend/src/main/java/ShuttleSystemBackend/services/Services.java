package ShuttleSystemBackend.services;

import java.util.Set;

/**
 * Created by User on 2017/09/07.
 */
public interface Services <E,ID> {
    E create(E entity);

    E readById(ID id);

    Set<E> readAll();

    E update(E entity);

    void delete(E entity);

}

