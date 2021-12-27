package com.company.controller;

import com.company.entity.Address;
import com.company.entity.ResponseWrapper;
import com.company.entity.Teacher;
import com.company.repository.AddressRepository;
import com.company.repository.ParentRepository;
import com.company.repository.StudentRepository;
import com.company.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ApiController {
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private ParentRepository parentRepository;
    private AddressRepository addressRepository;

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getStudents() {
        return ResponseEntity.ok(new ResponseWrapper("students are successfully retrieved", studentRepository.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getParents() {
        ResponseWrapper responseWrapper = new ResponseWrapper(true, "parents are successfully retrieved", HttpStatus.ACCEPTED.value(), parentRepository.findAll());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address) throws Exception {
        Optional<Address> foundAddress = addressRepository.findById(id);

        if (!foundAddress.isPresent()) {
            throw new Exception("Address does not exist!");
        }
        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));
        address.setId(foundAddress.get().getId());
        return addressRepository.save(address);
    }
}
