package tk.juanbody.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.juanbody.dto.JwtRequestDto;
import tk.juanbody.dto.UserDto;
import tk.juanbody.service.UserService;
import tk.juanbody.util.ConstantsController;
import tk.juanbody.util.ResultDto;
import tk.juanbody.util.Util;

@Controller
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(ConstantsController.REST_USERS_CREATE)
    public ResultDto createUser(@RequestBody UserDto userDto) {
        try {
            if (userDto == null)
                throw new Exception("El usuario no puede estar vacio.");
            if (Strings.isBlank(userDto.getUserName()))
                throw new Exception("El nombre de usuario no puede estar vacio.");
            if (Strings.isBlank(userDto.getPassword()))
                throw new Exception("El password no puede estar vacio.");
            if (Strings.isBlank(userDto.getAge()))
                throw new Exception("La edad no puede estar vacia.");
            if (Strings.isBlank(userDto.getHeight()))
                throw new Exception("La altura no puede estar vacia.");
            if (Strings.isBlank(userDto.getWeight()))
                throw new Exception("El peso no puede estar vacio.");
            UserDto userValidation = userService.getByUserName(userDto.getUserName());
            if (userValidation != null)
                throw new Exception("Usuario con este nombre de usuario ya existe.");
            return new ResultDto(ResultDto.STATUS_OK, userService.save(userDto));
        } catch (Exception ex) {
            LOGGER.error("ERROR CREATING USER: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResultDto(ResultDto.STATUS_ERROR, ex.getMessage());
        }
    }

    @ResponseBody
    @PostMapping(ConstantsController.REST_USERS_LOGIN)
    public ResultDto loginUser(@RequestBody JwtRequestDto jwtRequestDto) {
        try {
            if (jwtRequestDto == null)
                throw new Exception("El usuario no puede estar vacio.");
            if (Strings.isBlank(jwtRequestDto.getUsername()))
                throw new Exception("El nombre de usuario no puede estar vacio.");
            if (Strings.isBlank(jwtRequestDto.getPassword()))
                throw new Exception("El password no puede estar vacio.");
            UserDto userLogin = userService.findByUserName(jwtRequestDto.getUsername());
            if (userLogin == null)
                throw new Exception("Usuario y/opassword no validos.");
            if (!userLogin.getPassword().equals(Util.hashPassword(jwtRequestDto.getPassword())))
                throw new Exception("Usuario y/opassword no validos.");
            return new ResultDto(ResultDto.STATUS_OK, userLogin);
        } catch (Exception ex) {
            LOGGER.error("ERROR LOGIN USER: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResultDto(ResultDto.STATUS_ERROR, ex.getMessage());
        }
    }
}
