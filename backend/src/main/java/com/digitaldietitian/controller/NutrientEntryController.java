package com.digitaldietitian.controller;

import com.digitaldietitian.entity.NutritionLog;
import com.digitaldietitian.service.NutritionLogService;
import com.digitaldietitian.entity.NutrientEntry;
import com.digitaldietitian.service.NutrientEntryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
public class NutrientEntryController {
    private final NutrientEntryService service;

    public NutrientEntryController(NutrientEntryService service) {
        this.service = service;
    }

    // -------------------------------------------------------------------------
    // GET /api/nutrition/under
    // returns all nutrients at least 10% under the goal
    // --------------------------------------------------------------------------
    @GetMapping("/under")
    public ResponseEntity<List<NutrientEntry>> getUnder() {
        double threshold = 90.0; // 90% of the goal means 10% under
        List<NutrientEntry> entries = service.getUnder(threshold);
        return ResponseEntity.ok(entries);
    }
    
}
