package com.rnrsolutions.greenbless.forecast.controller;

import com.rnrsolutions.greenbless.forecast.dto.ForecastingDTO;
import com.rnrsolutions.greenbless.forecast.entity.ForecastingEntity;
import com.rnrsolutions.greenbless.forecast.service.ForecastingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/forecasting")
public class ForecastingController {
    private static final Logger logger = LoggerFactory.getLogger(ForecastingController.class);

    @Autowired
    private ForecastingService forecastingService;

    @PostMapping("/saveDTO")
    public String saveForecasting(@RequestBody ForecastingDTO pForecastingDTO) throws Exception {
        return forecastingService.saveForecasting(pForecastingDTO.getForecastItemID(), pForecastingDTO.getForecastingTypeID(), pForecastingDTO.getForecastingValue(),
                pForecastingDTO.getForecastDateTime(), pForecastingDTO.getCreatedDateTime(), pForecastingDTO.getUpdatedDateTime(), pForecastingDTO.getIsActive());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteForecasting(@PathVariable int id) throws Exception {
        forecastingService.deleteForecastingById(id);
        return "Successfully Deleted!";
    }

    @GetMapping("getAll")
    public List<ForecastingEntity> getAllForecastingEntities() throws Exception{
        return forecastingService.getAllForecastingEntities();
    }

    @PutMapping("/update")
    public String updateForecasting(@RequestBody ForecastingDTO pForecastingDTO) throws Exception{

        logger.info("ForecastingDTO.getId                   value:" + pForecastingDTO.getID());
        logger.info("ForecastingDTO.getForecastItemID()     value:" + pForecastingDTO.getForecastItemID());
        logger.info("ForecastingDTO.getForecastingTypeID()  value:" + pForecastingDTO.getForecastingTypeID());
        logger.info("ForecastingDTO.getForecastingValue     value:" + pForecastingDTO.getForecastingValue());
        logger.info("ForecastingDTO.getForecastDateTime()   value:" + pForecastingDTO.getForecastDateTime());
        logger.info("ForecastingDTO.getCreatedDateTime()    value:" + pForecastingDTO.getCreatedDateTime());
        logger.info("ForecastingDTO.getUpdatedDateTime()    value:" + pForecastingDTO.getUpdatedDateTime());
        logger.info("ForecastingDTO.getIsActive()           value:" + pForecastingDTO.getIsActive());

        return forecastingService.updateForecasting(pForecastingDTO.getID(), pForecastingDTO.getForecastItemID(),pForecastingDTO.getForecastingTypeID()
                ,pForecastingDTO.getForecastingValue(),pForecastingDTO.getForecastDateTime(),pForecastingDTO.getCreatedDateTime(),
                pForecastingDTO.getUpdatedDateTime(),pForecastingDTO.getIsActive());
    }
}
