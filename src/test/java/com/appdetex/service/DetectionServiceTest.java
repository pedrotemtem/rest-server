package com.appdetex.service;

import com.appdetex.entity.Detection;
import com.appdetex.repository.DetectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DetectionServiceTest {

    @Mock
    private Detection detection;

    @Mock
    private DetectionRepository detectionRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void getDetectionsById(){
        detection.setId(1);
        detection.setTitle("abc");
        detection.setDescription("abc");
        detectionRepository.save(detection);

        assertEquals(0,detection.getId());

    }

}