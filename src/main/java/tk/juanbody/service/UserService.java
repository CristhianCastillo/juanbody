package tk.juanbody.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import tk.juanbody.dto.UserDto;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    List<UserDto> getAll();

    UserDto getById(Long id);

    UserDto getByUserName(String userName);

    UserDto findByUserName(String userName);

    UserDto save(UserDto user);

    UserDto update(UserDto user);

    void delete(Long id);

    void delete(UserDto user);

}
