package tk.juanbody.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.juanbody.service.TrainingService;
import tk.juanbody.util.ConstantsController;
import tk.juanbody.util.ResultDto;

@Controller
public class TrainingController {

    public static final Logger LOGGER = LoggerFactory.getLogger(TrainingController.class);

    @Autowired
    private TrainingService trainingService;

    @ResponseBody
    @GetMapping(ConstantsController.REST_TRAININGS_GET)
    public ResultDto getAllTrainings() {
        try {
            return new ResultDto(ResultDto.STATUS_OK, trainingService.findAll());
        } catch (Exception ex) {
            LOGGER.error("ERROR GET ALL TRAININGS: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResultDto(ResultDto.STATUS_ERROR, ex.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(ConstantsController.REST_TRAININGS_GET_ID)
    public ResultDto getAllTrainings(@PathVariable Long id) {
        try {
            return new ResultDto(ResultDto.STATUS_OK, trainingService.findById(id));
        } catch (Exception ex) {
            LOGGER.error("ERROR GET TRAININGS BY ID: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResultDto(ResultDto.STATUS_ERROR, ex.getMessage());
        }
    }
}
