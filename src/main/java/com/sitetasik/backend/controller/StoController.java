package com.sitetasik.backend.controller;

import com.sitetasik.backend.model.Sto;
import com.sitetasik.backend.service.StoService;
import com.sitetasik.backend.utils.TemplateResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/sto")
public class StoController implements Serializable {
    @Autowired
    StoService stoService;
    @Autowired
    TemplateResponse templateResponse;

    @PostMapping("/add/{iddatel}")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map> save(@PathVariable(value = "iddatel") UUID idDatel,
                                    @RequestBody Sto stoObj) {
        Map obj = stoService.insertSto(stoObj, idDatel);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }
}
