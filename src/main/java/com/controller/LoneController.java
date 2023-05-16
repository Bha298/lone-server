package com.controller;

import com.entity.Lone;
import com.server.LonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class LoneController {

    @Autowired
    private LonaService lonaService;

    @GetMapping(path = "/loans")
    public ResponseEntity<List<Lone>> getLoansByType(@RequestParam("type") String type) {
        return ResponseEntity.ok().body(lonaService.getAllLoansByType(type.toUpperCase()));
    }
}
