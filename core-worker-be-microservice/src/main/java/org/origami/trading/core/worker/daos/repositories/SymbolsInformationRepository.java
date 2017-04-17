package org.origami.trading.core.worker.daos.repositories;


import org.origami.trading.core.worker.entities.HistoricalDailyBar;
import org.origami.trading.core.worker.entities.SymbolInformation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dmoreira on 4/16/17.
 */

public interface SymbolsInformationRepository extends CrudRepository<SymbolInformation, String> {

    @Override
    List<SymbolInformation> findAll();

    @Override
    SymbolInformation save(SymbolInformation s);

    @Override
    SymbolInformation findOne(String s);

    @Override
    void delete(String s);
}
