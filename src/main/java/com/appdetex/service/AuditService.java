package com.appdetex.service;

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

    public List<Audit> getByMarketplaceDetection(int marketplace_detections_id)  {
        return auditRepository.findByMarketplaceDetectionsId(marketplace_detections_id);
    }

    public Audit createAudit (CreateAuditRequest createAuditRequest){
        Audit audit = new Audit(createAuditRequest);
        audit = auditRepository.save(audit);
        return audit;
    }

    public Audit updateAudit(UpdateAuditRequest updateAuditRequest){
        Audit audit = auditRepository.findById(updateAuditRequest.getId()).get();

        if(updateAuditRequest.getAnalysts_id() != 0){
            audit.setAnalysts_id(updateAuditRequest.getAnalysts_id());
        }
        if(updateAuditRequest.getMarketplace_detections_id() != 0){
            audit.setMarketplaceDetectionsId(updateAuditRequest.getMarketplace_detections_id());
        }
        if(updateAuditRequest.getParameter() != null && !updateAuditRequest.getParameter().isEmpty()){
            audit.setParameter(updateAuditRequest.getParameter());
        }
        if(updateAuditRequest.getDate_time() != null && !updateAuditRequest.getDate_time().isEmpty()){
            audit.setDate_time(updateAuditRequest.getDate_time());
        }

        audit = auditRepository.save(audit);
        return audit;
    }

    public String deleteAudit(int id){
        auditRepository.deleteById(id);
        return "Audit has been deleted successfully";
    }

}