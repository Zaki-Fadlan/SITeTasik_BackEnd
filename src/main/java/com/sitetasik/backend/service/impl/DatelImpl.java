package com.sitetasik.backend.service.impl;

import com.sitetasik.backend.model.Datel;
import com.sitetasik.backend.repository.DatelRepository;
import com.sitetasik.backend.service.DatelService;
import com.sitetasik.backend.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatelImpl implements DatelService {
    @Autowired
    public TemplateResponse templateResponse;
    @Autowired
    public DatelRepository datelRepository;

    @Override
    public Map insertDatel(Datel datel) {
        try {
            if (templateResponse.checkNull(datel.getNamaDatel()) || datel.getNamaDatel().isEmpty()) {
                return templateResponse.templateError("Mohon masukan nama datel");
            }
            Datel datelObj = datelRepository.save(datel);
            return templateResponse.templateSuccess(datelObj);
        } catch (Exception e) {
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Map updateDatel(Datel datel) {
        try {
            Datel checkIdDatel = datelRepository.getById(datel.getId());
            if (templateResponse.checkNull(datel.getId()) || templateResponse.checkNull(checkIdDatel)) {
                return templateResponse.templateError("Datel tidak ditemukan");
            }

            checkIdDatel.setNamaDatel(datel.getNamaDatel());
            Datel dosave = datelRepository.save(checkIdDatel);
            return templateResponse.templateSuccess(dosave);

        } catch (Exception e) {
            return templateResponse.templateError(e);
        }
    }

    @Override
    public List<Datel> getAll() {
        return datelRepository.getAll();
    }
}
