package com.softtek_preview.api_application.controller;

import com.softtek_preview.api_application.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cost")
public class CostController {

    @Autowired
    private CostService costService;
}
