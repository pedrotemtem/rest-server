package com.appdetex.service;

import com.appdetex.repository.AuditRepository;
import com.appdetex.request.CreateAuditRequest;
import com.appdetex.entity.Audit;
import com.appdetex.request.UpdateAuditRequest;
import org.hibernate.service.spi.InjectService;
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

    public List<Audit> getByDetectionId(int detectionId) {

        return auditRepository.findByDetectionId(detectionId);
    }

    public Audit createAudit(CreateAuditRequest createAuditRequest) {

        Audit audit = new Audit(createAuditRequest);
        return auditRepository.save(audit);
    }

    public Audit updateAudit(UpdateAuditRequest updateAuditRequest) {

        Audit audit = auditRepository.findById(updateAuditRequest.getId()).get();

        if (updateAuditRequest.getUserId() != 0) {
            audit.setUserId(updateAuditRequest.getUserId());
        }
        if (updateAuditRequest.getDetectionId() != 0) {
            audit.setDetectionId(updateAuditRequest.getDetectionId());
        }
        if (updateAuditRequest.getParameter() != null && !updateAuditRequest.getParameter().isEmpty()) {
            audit.setParameter(updateAuditRequest.getParameter());
        }
        if (updateAuditRequest.getOldValue() != null && !updateAuditRequest.getOldValue().isEmpty()) {
            audit.setOldValue(updateAuditRequest.getOldValue());
        }
        if (updateAuditRequest.getNewValue() != null && !updateAuditRequest.getNewValue().isEmpty()) {
            audit.setNewValue(updateAuditRequest.getNewValue());
        }
        if (updateAuditRequest.getDateTime() != null && !updateAuditRequest.getDateTime().isEmpty()) {
            audit.setDateTime(updateAuditRequest.getDateTime());
        }

        return auditRepository.save(audit);
    }

    public String deleteAudit(int id) {

        auditRepository.deleteById(id);
        return "Audit has been deleted successfully";
    }

}