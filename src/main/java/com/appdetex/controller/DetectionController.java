package com.appdetex.controller;

import com.appdetex.entity.Detection;
import com.appdetex.request.CreateDetectionRequest;
import com.appdetex.request.UpdateDetectionRequest;
import com.appdetex.response.DetectionResponse;
import com.appdetex.service.AuditService;
import com.appdetex.service.DetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/detections/")
public class DetectionController {

    @Autowired
    DetectionService detectionService;
    AuditService auditService;

    @GetMapping("getAll")
    public List<DetectionResponse> getAllDetections() {

        List<Detection> detectionList = detectionService.getAllDetections();
        List<DetectionResponse> detectionResponseList = new ArrayList<DetectionResponse>();

        detectionList.stream().forEach(detection -> {
            detectionResponseList.add(new DetectionResponse(detection));
        });

        return detectionResponseList;
    }

    @GetMapping("numberByDay/{initialDate}/{endingDate}")
    public ArrayList<String> getNumberDetectionsByDay(@PathVariable String initialDate, @PathVariable String endingDate) {

        return detectionService.getDetectionsByDay(initialDate, endingDate);
    }

    @GetMapping("getById/{id}")
    public DetectionResponse getDetectionById(@PathVariable int id) {

        Detection detection = detectionService.getDetection(id);
        return new DetectionResponse(detection);
    }

    @GetMapping("getByAccount/{accountId}")
    public List<DetectionResponse> getByAccountId(@PathVariable int accountId){

        List<Detection> detectionList = detectionService.getByAccountId(accountId);
        List<DetectionResponse> detectionResponseList = new ArrayList<DetectionResponse>();

        detectionList.stream().forEach(detection -> {
            detectionResponseList.add(new DetectionResponse(detection));
        });

        return detectionResponseList;
    }

    @PostMapping("create")
    public DetectionResponse createDetection(@RequestBody CreateDetectionRequest createDetectionRequest) {

        Detection detection = detectionService.createDetection(createDetectionRequest);
        return new DetectionResponse(detection);
    }

    @PutMapping("update")
    public DetectionResponse updateDetection(@RequestBody UpdateDetectionRequest updateDetectionRequest){

        Detection detection = detectionService.updateDetection(updateDetectionRequest);
        return new DetectionResponse(detection);
    }

    @DeleteMapping("delete")
    public String deleteDetection(@RequestParam int id){

        return detectionService.deleteDetection(id);
    }
}
