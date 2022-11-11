package com.appdetex.service;

import com.appdetex.repository.AnalystRepository;
import com.appdetex.entity.Analyst;
import com.appdetex.request.CreateAnalystRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalystService {

    @Autowired
    AnalystRepository analystRepository;

    public List<Analyst> getAllAnalysts() {
        return analystRepository.findAll();
    }

    public Analyst createAnalyst (CreateAnalystRequest createAnalystRequest){
        Analyst analyst = new Analyst(createAnalystRequest);
        analyst = analystRepository.save(analyst);
        return analyst;
    }
}
