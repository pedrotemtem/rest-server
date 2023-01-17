package com.appdetex.service;

import com.appdetex.entity.Detection;
import com.appdetex.repository.DetectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Needs fix, not working properly
@ExtendWith(MockitoExtension.class)
class DetectionServiceTest {

    @Mock
    private Detection detection;

    @Mock
    private DetectionRepository detectionRepository;

    @BeforeEach
    public void setup(){
        detection.setId(1);
        detection.setTitle("abc");
        detection.setUrl("abc");
        detection.setDescription("abc");
        detectionRepository.save(detection);
    }

    @Test
    public void getDetectionsById(){

        assertEquals(1,detection.getId());

    }

}