package com.sitetasik.backend.controller;

import com.sitetasik.backend.model.Datel;
import com.sitetasik.backend.repository.DatelRepository;
import com.sitetasik.backend.service.DatelService;
import com.sitetasik.backend.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/datel")
public class DatelController {

    @Autowired
    DatelService datelService;
    @Autowired
    DatelRepository datelRepository;
    @Autowired
    TemplateResponse templateResponse;

    @PostMapping("/add")
    public ResponseEntity<Map> save(@RequestBody Datel datelObj) {
        Map map = new HashMap();
        Map obj = datelService.insertDatel(datelObj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@RequestBody Datel datelObj) {
        Map obj = datelService.updateDatel(datelObj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getId(@PathVariable(value = "id") UUID id) {
        Datel obj = datelRepository.getById(id);
        if (templateResponse.checkNull(obj)) {
            return new ResponseEntity<Map>(templateResponse.templateError("Datel tidak ditemukan"), HttpStatus.OK);
        }
        return new ResponseEntity<Map>(templateResponse.templateSuccess(obj), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Datel>> getAll() {
        List<Datel> list = datelRepository.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
