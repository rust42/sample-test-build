package edu.miu.cs590.userservice.serviceimpl;

import edu.miu.cs590.userservice.dto.UserDto;
import edu.miu.cs590.userservice.dto.UserSaveDto;
import edu.miu.cs590.userservice.exception.UserAlreadyExistException;
import edu.miu.cs590.userservice.mapper.UserSaveMapper;
import edu.miu.cs590.userservice.repository.UserRepository;
import edu.miu.cs590.userservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImpl implements UserService {

    private UserSaveMapper userSaveMapper;
    private UserRepository userRepository;

    public UserServiceImpl(UserSaveMapper userSaveMapper,UserRepository userRepository) {
        this.userSaveMapper=userSaveMapper;
        this.userRepository=userRepository;
    }

    @Override
    public UserDto saveUser(UserSaveDto userSaveDto) {
        userRepository.findByEmail(userSaveDto.getEmail()).ifPresent(user -> {throw new UserAlreadyExistException("Email "+user.getEmail()+ " already exist!");});
        return userSaveMapper.toDto(userRepository.save(userSaveMapper.toEntity(userSaveDto)));
    }

    @Override
    public Boolean checkUser(String email){
        return userRepository.findByEmail(email).isPresent();
    }
}
