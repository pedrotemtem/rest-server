package com.appdetex.controller;

import com.appdetex.response.AnalystResponse;
import com.appdetex.service.AnalystService;
import com.appdetex.entity.Analyst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/analysts/")
public class AnalystController {

    @Autowired
    AnalystService analystService;

    @GetMapping("/getAll")
    public List<AnalystResponse> getAllAnalysts() {
        List<Analyst> analystList = analystService.getAllAnalysts();
        List<AnalystResponse> analystResponseList = new ArrayList<AnalystResponse>();

        analystList.stream().forEach(analyst -> {
            analystResponseList.add(new AnalystResponse(analyst));
        });

        return analystResponseList;
    }
}
