package com.softtek_preview.api_application.controller;

import com.softtek_preview.api_application.domain.project.ProjectRequestDTO;
import com.softtek_preview.api_application.domain.project.ProjectResponseDTO;
import com.softtek_preview.api_application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
        ProjectResponseDTO project = projectService.createProject(projectRequestDTO);
        return ResponseEntity.ok(project);
    }
    
    @PostMapping("/bulk")
    public ResponseEntity<List<ProjectResponseDTO>> createProjectsInBulk(@RequestBody List<ProjectRequestDTO> projectRequestDTOs) {
        List<ProjectResponseDTO> createdProjects = projectService.createProjectsInBulk(projectRequestDTOs);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable UUID id) {
        ProjectResponseDTO project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        List<ProjectResponseDTO> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable UUID id, @RequestBody ProjectRequestDTO projectRequestDTO) {
        ProjectResponseDTO project = projectService.updateProject(id, projectRequestDTO);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
