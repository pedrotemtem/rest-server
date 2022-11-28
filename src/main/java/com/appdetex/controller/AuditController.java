package com.appdetex.controller;

import com.appdetex.request.CreateAuditRequest;
import com.appdetex.request.UpdateAuditRequest;
import com.appdetex.response.AuditResponse;
import com.appdetex.service.AuditService;
import com.appdetex.entity.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/audit/")
public class AuditController {
    @Autowired
    AuditService auditService;

    @GetMapping("getAll")
    public List<AuditResponse> getAllAudits(){
        List<Audit> auditList = auditService.getAllAudits();
        List<AuditResponse> auditResponseList = new ArrayList<AuditResponse>();

        auditList.stream().forEach(audit -> {
            auditResponseList.add(new AuditResponse(audit));
        });

        return auditResponseList;
    }

    @GetMapping("getByMarketplaceDetection/{marketplace_detections_id}")
    public List<AuditResponse> getByMarketplaceDetection(@PathVariable int marketplace_detections_id){
        List<Audit> auditList = auditService.getByMarketplaceDetection(marketplace_detections_id);
        List<AuditResponse> auditResponseList = new ArrayList<AuditResponse>();

        auditList.stream().forEach(audit -> {
            auditResponseList.add(new AuditResponse(audit));
        });

        return auditResponseList;
    }

    @PostMapping("create")
    public AuditResponse createAudit(@RequestBody CreateAuditRequest createAuditRequest){
        Audit audit = auditService.createAudit(createAuditRequest);

        return new AuditResponse(audit);
    }

    @PutMapping("update")
    public AuditResponse updateAudit(@Valid @RequestBody UpdateAuditRequest updateAuditRequest){
        Audit audit = auditService.updateAudit(updateAuditRequest);

        return new AuditResponse(audit);
    }

    @DeleteMapping("delete/{id}")
    public String deleteAudit(@PathVariable int id){
        return auditService.deleteAudit(id);
    }

}