package com.progbm.Moogle.sample;

import com.progbm.Moogle.response.ResponseService;
import com.progbm.Moogle.response.dto.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    private final ResponseService responseService;

    @GetMapping("/sample")
    public ResponseEntity getSingleHello() {
        Sample result = sampleService.getSample();
        DataResponse<Sample> response = responseService.getDataResponse(result, HttpStatus.OK);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
