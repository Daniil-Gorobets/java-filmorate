package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.model.Mpa;
import ru.yandex.practicum.filmorate.service.MpaService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/mpa")
public class MpaController {

    @Autowired
    private MpaService mpaService;

    @GetMapping
    public List<Mpa> findAll() {
        log.info("Request endpoint: 'GET /mpa'");
        return mpaService.getAll();
    }

    @GetMapping("/{id}")
    public Mpa getMpa(@PathVariable int id) {
        log.info("Request endpoint: 'GET /mpa/{}'", id);
        return mpaService.getById(id);
    }
}
