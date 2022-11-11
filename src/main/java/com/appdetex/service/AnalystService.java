package com.appdetex.service;

import com.appdetex.entity.Audit;
import com.appdetex.repository.AnalystRepository;
import com.appdetex.entity.Analyst;
import com.appdetex.request.CreateAnalystRequest;
import com.appdetex.request.UpdateAnalystRequest;
import com.appdetex.request.UpdateAuditRequest;
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

    public Analyst updateAnalyst (UpdateAnalystRequest updateAnalystRequest){
        Analyst analyst = analystRepository.findById(updateAnalystRequest.getId()).get();

        if(updateAnalystRequest.getName() != null && !updateAnalystRequest.getName().isEmpty()){
            analyst.setName(updateAnalystRequest.getName());
        }
        if(updateAnalystRequest.getEmail() != null && !updateAnalystRequest.getEmail().isEmpty()){
            analyst.setEmail(updateAnalystRequest.getEmail());
        }
        if(updateAnalystRequest.getPassword() != null && !updateAnalystRequest.getPassword().isEmpty()){
            analyst.setPassword(updateAnalystRequest.getPassword());
        }

        analyst = analystRepository.save(analyst);
        return analyst;
    }
}
