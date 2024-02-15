package com.rnrsolutions.greenbless.forecast.controller;

import com.rnrsolutions.greenbless.forecast.dto.ForecastItemDTO;
import com.rnrsolutions.greenbless.forecast.entity.ForecastItemEntity;
import com.rnrsolutions.greenbless.forecast.service.ForecastItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/forecastItem")
public class ForecastItemController {
    private static final Logger logger = LoggerFactory.getLogger(ForecastItemController.class);

    @Autowired
    private ForecastItemService forecastItemService;

    @PostMapping("/saveDTO")
    public String saveForecastItemDTO(
            @RequestBody ForecastItemDTO pForecastItemDTO) throws Exception {
        return forecastItemService.saveForecastItem(pForecastItemDTO.getItemName(),
                pForecastItemDTO.getForecastingInterval()
        );
    }

    @DeleteMapping("/delete/{id}")
    public String deleteForecastItemById(@PathVariable int id) throws Exception {
        forecastItemService.deleteForecastItemById(id);
        return "Successfully Deleted!";
    }


    @GetMapping("/getAll")
    public List<ForecastItemEntity> getAllDeviceForecastItems() throws Exception {
        return forecastItemService.getAllDeviceForecastItems();
    }

    @PutMapping("/update")
    public String updateForecastItem(@RequestBody ForecastItemDTO pForecastItemDTO) throws Exception {

        logger.info("ForecastItemDTO.getId                   value:" + pForecastItemDTO.getId());
        logger.info("ForecastItemDTO.getForecastItemID()     value:" + pForecastItemDTO.getForecastingInterval());
        logger.info("ForecastItemDTO.getForecastingTypeID()  value:" + pForecastItemDTO.getItemName());

        return forecastItemService.updateForecastItem(pForecastItemDTO.getId(), pForecastItemDTO.getItemName(),
                pForecastItemDTO.getForecastingInterval());
    }
}
