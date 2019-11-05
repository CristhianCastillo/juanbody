package tk.juanbody.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tk.juanbody.config.JwtTokenUtil;
import tk.juanbody.dto.UserDto;
import tk.juanbody.model.UserEntity;
import tk.juanbody.repository.UserRepository;
import tk.juanbody.util.Util;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class IUserService implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findByUserName(userName);
        if (userEntity != null)
            return new org.springframework.security.core.userdetails.User(userEntity.getUserName(), userEntity.getPassword(),
                    new ArrayList<>());
        else
            throw new UsernameNotFoundException("User not found with username: " + userName);
    }

    @Override
    @Transactional
    public List<UserDto> getAll() {
        List<UserDto> result = new ArrayList<>();
        repository.findAll().forEach(e -> result.add(modelMapper.map(e, UserDto.class)));
        return result;
    }

    @Override
    @Transactional
    public UserDto getById(Long id) {
        return modelMapper.map(repository.findById(id).get(), UserDto.class);
    }

    @Override
    @Transactional
    public UserDto save(UserDto user) {
        user.setPassword(Util.hashPassword(user.getPassword()));
        return modelMapper.map(repository.save(modelMapper.map(user, UserEntity.class)), UserDto.class);
    }

    @Override
    @Transactional
    public UserDto update(UserDto user) {
        return modelMapper.map(repository.save(modelMapper.map(user, UserEntity.class)), UserDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(UserDto user) {
        repository.delete(modelMapper.map(user, UserEntity.class));
    }

    @Override
    @Transactional
    public UserDto getByUserName(String userName) {
        UserEntity userEntity = repository.findByUserName(userName);
        if (userEntity != null)
            return modelMapper.map(userEntity, UserDto.class);
        else return null;
    }

    @Override
    @Transactional
    public UserDto findByUserName(String userName) {
        final UserDetails userDetails = loadUserByUsername(userName);
        final String token = jwtTokenUtil.generateToken(userDetails);
        UserEntity userEntity = repository.findByUserName(userName);
        if (userEntity != null) {
            UserDto userDto = modelMapper.map(userEntity, UserDto.class);
            userDto.setToken(token);
            return userDto;
        } else
            return null;
    }
}
