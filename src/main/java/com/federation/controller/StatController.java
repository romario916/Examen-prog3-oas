package com.federation.controller;

import com.federation.model.FederationStat;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatController {

    @GetMapping("/report")
    public List<FederationStat> getGlobalReport(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return new ArrayList<>();
    }
}
