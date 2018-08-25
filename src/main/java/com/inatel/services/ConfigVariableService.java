package com.inatel.services;

import com.inatel.domain.ConfigVariable;

import java.util.List;

public interface ConfigVariableService {

    List<ConfigVariable> getAllConfiguration();

    ConfigVariable saveConfiguration(ConfigVariable configuration);

    List<ConfigVariable> saveConfiguration(List<ConfigVariable> configurationList);

    ConfigVariable getConfigurationByName(String name);

    ConfigVariable updateConfigurationByName(ConfigVariable configVariable);

    ConfigVariable deleteConfigurationByName(String name);
}
