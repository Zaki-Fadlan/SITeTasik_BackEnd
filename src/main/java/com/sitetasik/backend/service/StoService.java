package com.sitetasik.backend.service;

import com.sitetasik.backend.model.Sto;

import java.util.Map;
import java.util.UUID;

public interface StoService {
    public Map insertSto(Sto sto, UUID idDatel);
}
