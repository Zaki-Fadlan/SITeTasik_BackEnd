package com.sitetasik.backend.service.impl;

import com.sitetasik.backend.model.Datel;
import com.sitetasik.backend.model.Sto;
import com.sitetasik.backend.repository.DatelRepository;
import com.sitetasik.backend.repository.StoRepository;
import com.sitetasik.backend.service.StoService;
import com.sitetasik.backend.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class StoImpl implements StoService {
    @Autowired
    public TemplateResponse templateResponse;
    @Autowired
    public StoRepository stoRepository;
    @Autowired
    public DatelRepository datelRepository;

    @Override
    public Map insertSto(Sto sto, UUID idDatel) {
        try {
            if (templateResponse.checkNull(sto.getNamaSto()) || sto.getNamaSto().isEmpty()) {
                return templateResponse.templateError("Masukan nama STO !!");
            }
            if (sto.getNamaSto().length() > 3) {
                return templateResponse.templateError("Masukan nama STO dengan menggunakan inisisal 3 huruf saja !!");
            }
            Datel checkId = datelRepository.getById(idDatel);
            if (templateResponse.checkNull(checkId)) {
                return templateResponse.templateError("Masukan Datel yang sesuai");
            }
            sto.setDatel(checkId);
            Sto stoSave = stoRepository.save(sto);
            return templateResponse.templateSuccess(stoSave);
        } catch (Exception e) {
            return templateResponse.templateError(e);
        }
    }
}
