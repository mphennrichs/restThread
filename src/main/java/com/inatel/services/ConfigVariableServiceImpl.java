package com.inatel.services;

import com.inatel.domain.ConfigVariable;
import com.inatel.repositories.ConfigVariableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ConfigVariableServiceImpl implements ConfigVariableService {

    @Autowired
    ConfigVariableRepository configVariableRepository;

    @Override
    public List<ConfigVariable> getAllConfiguration() {
        List<ConfigVariable> allConfigs = new ArrayList<>();

        configVariableRepository.findAll().forEach(allConfigs::add);

        return allConfigs;
    }

    @Override
    public ConfigVariable saveConfiguration(ConfigVariable configuration) {
        return configVariableRepository.save(configuration);
    }

    @Override
    public List<ConfigVariable> saveConfiguration(List<ConfigVariable> configurationList) {
         configurationList.forEach(configVariable -> configVariableRepository.save(configVariable));

         return configurationList;
    }

    @Override
    public ConfigVariable getConfigurationByNameAndActiveTrue(String name) {
        return configVariableRepository.findConfigVariableByKeyAndActiveTrue(name);
    }

    //the update process will update only the fields active and value
    @Override
    public ConfigVariable updateConfigurationByName(ConfigVariable configVariable) {
        ConfigVariable configuration = configVariableRepository.findConfigVariableByKey(configVariable.getKey());
        configuration.setValue(configVariable.getValue());
        configuration.setActive(configVariable.getActive());

        log.info("[UPDATE] updated: " + configuration);

        return configVariableRepository.save(configuration);
    }

    @Override
    public ConfigVariable deleteConfigurationByName(String name) {
        ConfigVariable configuration = configVariableRepository.findConfigVariableByKeyAndActiveTrue(name);
        configuration.setActive(false);

        log.info("[DELETE] deleted: " + name);

        return configVariableRepository.save(configuration);
    }

}
