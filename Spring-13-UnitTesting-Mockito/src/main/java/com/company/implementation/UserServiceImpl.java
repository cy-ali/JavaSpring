package com.company.implementation;

import com.company.dto.ProjectDTO;
import com.company.dto.TaskDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.exception.TicketingProjectException;
import com.company.mapper.MapperUtil;
import com.company.mapper.UserMapper;
import com.company.repository.UserRepository;
import com.company.service.ProjectService;
import com.company.service.TaskService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private ProjectService projectService;
    private TaskService taskService;
    private MapperUtil mapperUtil;

    public UserServiceImpl(UserRepository userRepository, @Lazy ProjectService projectService, TaskService taskService, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.projectService = projectService;
        this.taskService = taskService;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> list = userRepository.findAll(Sort.by("firstName"));
        return list.stream().map(obj -> mapperUtil.convert(obj,new UserDTO())).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user = userRepository.findByUserName(username);
        return mapperUtil.convert(user,new UserDTO());
    }

    @Override
    public void save(UserDTO dto) {
       User obj =  mapperUtil.convert(dto,new User());
       userRepository.save(obj);
    }

    @Override
    public UserDTO update(UserDTO dto) {

        //Find current user
        User user = userRepository.findByUserName(dto.getUserName());
        //Map update user dto to entity object
        User convertedUser = mapperUtil.convert(dto,new User());
        //set id to the converted object
        convertedUser.setId(user.getId());
        //save updated user
        userRepository.save(convertedUser);

        return findByUserName(dto.getUserName());
    }

    @Override
    public void delete(String username) throws TicketingProjectException {
        User user = userRepository.findByUserName(username);

        if(user == null){
            throw new TicketingProjectException("User Does Not Exists");
        }

        if(!checkIfUserCanBeDeleted(user)){
            throw new TicketingProjectException("User can not be deleted. It is linked by a project ot task");
        }

        user.setUserName(user.getUserName() + "-" + user.getId());

        user.setIsDeleted(true);
        userRepository.save(user);
    }

    //hard delete
    @Override
    public void deleteByUserName(String username) {
        userRepository.deleteByUserName(username);
    }


    @Override
    public List<UserDTO> listAllByRole(String role) {
        List<User> users = userRepository.findAllByRoleDescriptionIgnoreCase(role);
        return users.stream().map(obj -> {return mapperUtil.convert(obj,new UserDTO());}).collect(Collectors.toList());
    }

    @Override
    public Boolean checkIfUserCanBeDeleted(User user) {

        switch(user.getRole().getDescription()){
            case "Manager":
                List<ProjectDTO> projectList = projectService.readAllByAssignedManager(user);
                return projectList.size() == 0;
            case "Employee":
                List<TaskDTO> taskList = taskService.readAllByEmployee(user);
                return taskList.size() == 0;
            default:
                return true;
        }
    }
}
