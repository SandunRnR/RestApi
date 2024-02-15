package com.rnrsolutions.greenbless.forecast.controller;

import com.rnrsolutions.greenbless.forecast.dto.ForecastTypeDTO;
import com.rnrsolutions.greenbless.forecast.entity.ForecastTypeEntity;
import com.rnrsolutions.greenbless.forecast.service.ForecastTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/forecastType")
public class ForecastTypeController {
    private static final Logger logger = LoggerFactory.getLogger(ForecastTypeController.class);

    @Autowired
    private ForecastTypeService forecastTypeService;

    @PostMapping("saveForecastType")
    public String saveForecastType(@RequestBody ForecastTypeDTO pForecastTypeDTO) throws Exception {
        return forecastTypeService.saveForecastType(pForecastTypeDTO.getName(), pForecastTypeDTO.getContributionOrder());
    }

    @DeleteMapping("delete/{id}")
    public String deleteForecastTypeById(@PathVariable int id) throws Exception {
        forecastTypeService.deleteForecastTypeById(id);
        return "Successfully Deleted!";
    }

    @GetMapping("getAll")
    public List<ForecastTypeEntity> getAllForecastType() throws Exception {
        return forecastTypeService.getAllForecastTypeEntity();
    }

    @PutMapping("/update")
    public String updateForecastType(@RequestBody ForecastTypeDTO pForecastTypeDTO) throws Exception {

        logger.info("ForecastTypeDTO.getID                  value:" + pForecastTypeDTO.getID());
        logger.info("ForecastTypeDTO.getName()              value:" + pForecastTypeDTO.getName());
        logger.info("ForecastTypeDTO.getContributionOrder() value:" + pForecastTypeDTO.getContributionOrder());

        return forecastTypeService.updateForecastType(pForecastTypeDTO.getID(), pForecastTypeDTO.getName(),
                pForecastTypeDTO.getContributionOrder());
    }
}
