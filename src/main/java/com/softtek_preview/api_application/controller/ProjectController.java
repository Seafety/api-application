package com.softtek_preview.api_application.controller;

import com.softtek_preview.api_application.domain.project.ProjectRequestDTO;
import com.softtek_preview.api_application.domain.project.ProjectResponseDTO;
import com.softtek_preview.api_application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    // Create a new project
    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
        ProjectResponseDTO project = projectService.createProject(projectRequestDTO);
        return ResponseEntity.ok(project);
    }

    // Get a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable UUID id) {
        ProjectResponseDTO project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    // Get all projects
    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        List<ProjectResponseDTO> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    // Update a project by ID
    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable UUID id, @RequestBody ProjectRequestDTO projectRequestDTO) {
        ProjectResponseDTO project = projectService.updateProject(id, projectRequestDTO);
        return ResponseEntity.ok(project);
    }

    // Delete a project by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
