package com.company.controller;

import com.company.entity.Cinema;
import com.company.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@AllArgsConstructor
@Tag(name = "Cinema", description = "Cinema API")
public class CinemaController {

    private CinemaRepository cinemaRepository;

    @Operation(summary = "Read all cinemas")
    @GetMapping("/all")
    public List<Cinema> readAll() {
        return cinemaRepository.findAll();
    }

}
