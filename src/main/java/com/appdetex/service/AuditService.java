package com.appdetex.service;

import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.repository.AuditRepository;
import com.appdetex.request.CreateAuditRequest;
import com.appdetex.entity.Audit;
import com.appdetex.request.UpdateAuditRequest;
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

    public List<Audit> getByMarketplaceDetectionId(int marketplaceDetectionsId)  {

        return auditRepository.findByMarketplaceDetectionsId(marketplaceDetectionsId);
    }

    public Audit createAudit (CreateAuditRequest createAuditRequest){

        Audit audit = new Audit(createAuditRequest);
        audit = auditRepository.save(audit);
        return audit;
    }

    public Audit updateAudit(UpdateAuditRequest updateAuditRequest) {

        Audit audit = auditRepository.findById(updateAuditRequest.getId()).get();

        if(updateAuditRequest.getAnalystsId() != 0){
            audit.setAnalystsId(updateAuditRequest.getAnalystsId());
        }
        if(updateAuditRequest.getMarketplaceDetectionsId() != 0){
            audit.setMarketplaceDetectionsId(updateAuditRequest.getMarketplaceDetectionsId());
        }
        if(updateAuditRequest.getParameter() != null && !updateAuditRequest.getParameter().isEmpty()){
            audit.setParameter(updateAuditRequest.getParameter());
        }
        if(updateAuditRequest.getOldValue() != null && !updateAuditRequest.getOldValue().isEmpty()){
            audit.setOldValue(updateAuditRequest.getOldValue());
        }
        if(updateAuditRequest.getNewValue() != null && !updateAuditRequest.getNewValue().isEmpty()){
            audit.setNewValue(updateAuditRequest.getNewValue());
        }
        if(updateAuditRequest.getDateTime() != null && !updateAuditRequest.getDateTime().isEmpty()){
            audit.setDateTime(updateAuditRequest.getDateTime());
        }

        audit = auditRepository.save(audit);
        return audit;
    }

    public String deleteAudit(int id){

        auditRepository.deleteById(id);
        return "Audit has been deleted successfully";
    }

}