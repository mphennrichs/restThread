package com.inatel.repositories;

import com.inatel.domain.ConfigVariable;
import org.springframework.data.repository.CrudRepository;

public interface ConfigVariableRepository extends CrudRepository<ConfigVariable, Long> {
    ConfigVariable findConfigVariableByKey(String name);
}
