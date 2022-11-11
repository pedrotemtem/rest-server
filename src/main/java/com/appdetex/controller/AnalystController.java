package com.appdetex.controller;

import com.appdetex.entity.Audit;
import com.appdetex.request.CreateAnalystRequest;
import com.appdetex.request.CreateAuditRequest;
import com.appdetex.response.AnalystResponse;
import com.appdetex.response.AuditResponse;
import com.appdetex.service.AnalystService;
import com.appdetex.entity.Analyst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/analysts/")
public class AnalystController {

    @Autowired
    AnalystService analystService;

    @GetMapping("getAll")
    public List<AnalystResponse> getAllAnalysts() {
        List<Analyst> analystList = analystService.getAllAnalysts();
        List<AnalystResponse> analystResponseList = new ArrayList<AnalystResponse>();

        analystList.stream().forEach(analyst -> {
            analystResponseList.add(new AnalystResponse(analyst));
        });

        return analystResponseList;
    }

    @PostMapping("create")
    public AnalystResponse createAnalyst(@RequestBody CreateAnalystRequest createAnalystRequest){
        Analyst analyst = analystService.createAnalyst(createAnalystRequest);

        return new AnalystResponse(analyst);
    }
}
