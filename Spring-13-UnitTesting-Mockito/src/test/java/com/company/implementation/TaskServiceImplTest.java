package com.company.implementation;

import com.company.dto.TaskDTO;
import com.company.entity.Task;
import com.company.mapper.TaskMapper;
import com.company.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L,2L,3L})
    void findByIdTest(long arg){

        Task task = new Task();

        Mockito.when(taskRepository.findById(arg)).thenReturn(Optional.of(task));
        Mockito.when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

        taskService.findById(arg);

        Mockito.verify(taskRepository).findById(arg);

    }


    @Test
    void findByIdBddTest(){

        //given
        Task task = new Task();
        given(taskRepository.findById(Mockito.anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

        //when
        taskService.findById(Mockito.anyLong());

        //then
        then(taskRepository).should().findById(Mockito.anyLong());
        then(taskRepository).should(never()).findById(-5L);

    }


}