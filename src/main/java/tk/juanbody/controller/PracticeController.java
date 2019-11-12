package tk.juanbody.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.juanbody.dto.PracticeDto;
import tk.juanbody.dto.UserDto;
import tk.juanbody.service.PracticeService;
import tk.juanbody.service.UserService;
import tk.juanbody.util.ConstantsController;
import tk.juanbody.util.ResultDto;

@Controller
@CrossOrigin
public class PracticeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(PracticeController.class);

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping(ConstantsController.REST_PRACTICES_USER_GET_ID)
    public ResultDto getUserPractices(@PathVariable Long id) {
        try {
            UserDto userDto = userService.getById(id);
            if (userDto == null || userDto.getId() == null)
                throw new Exception("El usuario no existe, valide nuevamente.");
            return new ResultDto(ResultDto.STATUS_OK, userDto.getPracticeEntities());
        } catch (Exception ex) {
            LOGGER.error("ERROR GET PRACTICE'S USER: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResultDto(ResultDto.STATUS_ERROR, ex.getMessage());
        }
    }

    @ResponseBody
    @PostMapping(ConstantsController.REST_PRACTICES_CREATE)
    public ResultDto createPractice(@RequestBody PracticeDto practiceDto) {
        try {
            return new ResultDto(ResultDto.STATUS_OK, practiceService.save(practiceDto));
        } catch (Exception ex) {
            LOGGER.error("ERROR CREATING PRACTICE: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResultDto(ResultDto.STATUS_ERROR, ex.getMessage());
        }
    }

}
