package com.sitetasik.backend.service;

import com.sitetasik.backend.model.Datel;

import java.util.List;
import java.util.Map;

public interface DatelService {
    public Map insertDatel(Datel datel);

    public Map updateDatel(Datel datel);

    List<Datel> getAll();
}
