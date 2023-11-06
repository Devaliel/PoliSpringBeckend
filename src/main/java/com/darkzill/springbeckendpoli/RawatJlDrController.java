package com.darkzill.springbeckendpoli;

import com.darkzill.springbeckendpoli.RawatJlDrService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RawatJlDrController {
    private final RawatJlDrService rawatJlDrService;

    public RawatJlDrController(RawatJlDrService rawatJlDrService) {
        this.rawatJlDrService = rawatJlDrService;
    }

    @GetMapping("/rawat-jl-dr")
    public ResponseEntity<?> getRawatJlDrByParameters(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String kdDokter
    ) {
        try {
            // Call the service method to retrieve the data
            List<Map<String, Object>> result = rawatJlDrService.findRawatJlDrByParameters(startDate, endDate, kdDokter);

            // Return the result as JSON response
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // Handle any errors and return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving data");
        }
    }
}
