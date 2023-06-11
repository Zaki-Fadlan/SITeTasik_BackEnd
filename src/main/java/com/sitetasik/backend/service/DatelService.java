package com.sitetasik.backend.service;

import com.sitetasik.backend.model.Datel;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DatelService {
    public Map insertDatel(Datel datel);

    public Map updateDatel(Datel datel);

    List<Datel> getAll();

    public Map delete(UUID datel);
}
