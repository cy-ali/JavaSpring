package com.company.implementation;

import com.company.mapper.MapperUtil;
import com.company.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    MapperUtil mapperUtil;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUserName() {

        userService.deleteByUserName("mike@mail.com");

//        verify(userRepository).deleteByUserName("mike@mail.com");
        verify(userRepository,times(2)).deleteByUserName("mike@mail.com");
        verify(userRepository,atLeastOnce()).deleteByUserName("mike@mail.com");
        verify(userRepository,atMost(5)).deleteByUserName("mike@mail.com");
    }
}