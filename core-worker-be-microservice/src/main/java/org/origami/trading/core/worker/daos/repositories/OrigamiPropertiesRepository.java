package org.origami.trading.core.worker.daos.repositories;


import org.origami.trading.core.worker.entities.OrigamiProperty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dmoreira on 4/16/17.
 */

public interface OrigamiPropertiesRepository extends CrudRepository<OrigamiProperty, String> {

    @Override
    List<OrigamiProperty> findAll();

    @Override
    OrigamiProperty save(OrigamiProperty s);

    @Override
    OrigamiProperty findOne(String s);

    @Override
    void delete(String s);
}
