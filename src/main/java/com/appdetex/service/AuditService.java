package com.appdetex.service;

import com.appdetex.repository.AuditRepository;
import com.appdetex.request.CreateAuditRequest;
import com.appdetex.entity.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    @Autowired
    AuditRepository auditRepository;

    public List<Audit> getAllAudits()  {
        return auditRepository.findAll();
    }

    public Audit createAudit (CreateAuditRequest createAuditRequest){
        Audit audit = new Audit(createAuditRequest);
        audit = auditRepository.save(audit);
        return audit;
    }

}