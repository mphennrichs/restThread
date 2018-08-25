package com.inatel.controllers;

import com.inatel.domain.ConfigVariable;
import com.inatel.services.ConfigVariableService;
import com.sun.xml.internal.ws.transport.http.WSHTTPConnection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("configvariable")
@Api(value="ConfigVariable")
public class ConfigVariableController {

    @Autowired
    ConfigVariableService configService;

    @GetMapping(path="/", produces = "application/json")
    @ApiOperation(value = "Retrieve a list of all Configurations",response = Iterable.class)
    public List<ConfigVariable> getAll(){

        return configService.getAllConfiguration();
    }

    @GetMapping(path = "/search", produces = "application/json")
    @ApiOperation(value = "Retrieve Configuration by id",response = ConfigVariable.class)
    public ConfigVariable getProductOfferingPrice(@RequestParam String name){

        return configService.getConfigurationByName(name);
    }

    @DeleteMapping(path = "/delete", produces = "application/json")
    @ApiOperation(value = "Delete Configuration by id",response = ConfigVariable.class)
    public ConfigVariable deleteProductOfferingPrice(@RequestParam String name){

        return configService.deleteConfigurationByName(name);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @ApiOperation(value = "Add a Configuration and return the same object if the operation succeeds",
            response = ConfigVariable.class)
    public ResponseEntity saveConfiguration(@RequestBody ConfigVariable configuration){
        try{

            configService.saveConfiguration(configuration);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(configuration);
    }

    @PostMapping(path = "/addList", consumes = "application/json")
    @ApiOperation(value = "Add a Configuration and return the same object if the operation succeeds",
            response = ConfigVariable.class)
    public ResponseEntity saveConfiguration(@RequestBody List<ConfigVariable> configurationList){
        try{

            configService.saveConfiguration(configurationList);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(configurationList);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    @ApiOperation(value = "Update ProductOfferingPrice data and return the same ProductOfferingPrice if the operation succeeds",
            response = ConfigVariable.class)
    public ResponseEntity updateProductOfferingPrice(@RequestBody ConfigVariable configuration){
        try{

            configService.updateConfigurationByName(configuration);

        } catch (Exception ex) {
            return ResponseEntity.status(WSHTTPConnection.INTERNAL_ERR).body(ex.getMessage());
        }

        return ResponseEntity.ok(configuration);
    }
}
