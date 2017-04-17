package org.origami.trading.core.worker.daos.repositories;


import org.origami.trading.core.worker.entities.HistoricalDailyBar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dmoreira on 4/16/17.
 */

public interface HistoricalDailyBarsRepository extends CrudRepository<HistoricalDailyBar, String> {

    @Override
    List<HistoricalDailyBar> findAll();

    @Override
    HistoricalDailyBar save(HistoricalDailyBar s);

    @Override
    HistoricalDailyBar findOne(String s);

    @Override
    void delete(String s);
}
