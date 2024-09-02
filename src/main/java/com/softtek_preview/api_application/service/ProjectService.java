package com.softtek_preview.api_application.service;

import com.softtek_preview.api_application.domain.consultant.Consultant;
import com.softtek_preview.api_application.domain.project.Project;
import com.softtek_preview.api_application.domain.project.ProjectRequestDTO;
import com.softtek_preview.api_application.domain.project.ProjectResponseDTO;
import com.softtek_preview.api_application.exceptions.ResourceNotFoundException;
import com.softtek_preview.api_application.repositories.ConsultantRepository;
import com.softtek_preview.api_application.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CustoVendaService custoVendaService;

    @Autowired
    private PiramideVendasService piramideVendasService;

    @Autowired
    private ConsultantRepository consultantRepository;

    public ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO) {
        if (projectRequestDTO.owners().size() > 3) {
            throw new IllegalArgumentException("A project can have a maximum of 3 owners.");
        }
        Project project = convertToEntity(projectRequestDTO);
        Project savedProject = projectRepository.save(project);
        return convertToDTO(savedProject);
    }

    public ProjectResponseDTO getProjectById(UUID id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        return convertToDTO(project);
    }

    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProjectResponseDTO updateProject(UUID id, ProjectRequestDTO projectRequestDTO) {
        if (projectRequestDTO.owners().size() > 3) {
            throw new IllegalArgumentException("A project can have a maximum of 3 owners.");
        }
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        updateFromDTO(project, projectRequestDTO);
        Project updatedProject = projectRepository.save(project);
        return convertToDTO(updatedProject);
    }

    public void deleteProject(UUID id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        projectRepository.delete(project);
    }

    private void updateFromDTO(Project project, ProjectRequestDTO dto) {
        project.setProjeto(dto.projeto());
        project.setDescricao(dto.descricao());
        Set<Consultant> owners = new HashSet<>(consultantRepository.findByIdIn(dto.owners()));
        project.setOwners(owners);
        project.setTipoContrato(dto.tipoContrato());
        project.setModulo(dto.modulo());
        project.setTipoDemanda(dto.tipoDemanda());
        project.setBaseline(dto.baseline());
        project.setValorContrato(dto.valorContrato());
        project.setPiramideVenda(piramideVendasService.convertToEntity(dto.piramideVendas()));
        project.setCustoVenda(custoVendaService.convertToEntity(dto.custoVenda()));
        project.setHorasGestao(dto.horasGestao());
        project.setBaselineConsumido(dto.baselineConsumido());
        project.setInicioContrato(dto.inicioContrato());
        project.setFimContrato(dto.fimContrato());
        project.setStatus(dto.status());
        project.setAtivo(dto.ativo());
    }
    private Project convertToEntity(ProjectRequestDTO dto) {
        Project project = new Project();
        project.setProjeto(dto.projeto());
        project.setDescricao(dto.descricao());
        Set<Consultant> owners = new HashSet<>(consultantRepository.findByIdIn(dto.owners()));
        project.setOwners(owners);
        project.setTipoContrato(dto.tipoContrato());
        project.setModulo(dto.modulo());
        project.setTipoDemanda(dto.tipoDemanda());
        project.setBaseline(dto.baseline());
        project.setValorContrato(dto.valorContrato());
        project.setPiramideVenda(piramideVendasService.convertToEntity(dto.piramideVendas()));
        project.setCustoVenda(custoVendaService.convertToEntity(dto.custoVenda()));
        project.setHorasGestao(dto.horasGestao());
        project.setBaselineConsumido(dto.baselineConsumido());
        project.setInicioContrato(dto.inicioContrato());
        project.setFimContrato(dto.fimContrato());
        project.setStatus(dto.status());
        project.setAtivo(dto.ativo());
        return project;
    }
    private ProjectResponseDTO convertToDTO(Project project) {
        Set<UUID> ownerIds = project.getOwners().stream()
                .map(Consultant::getId)
                .collect(Collectors.toSet());

        return new ProjectResponseDTO(
                project.getId(),
                project.getProjeto(),
                project.getDescricao(),
                ownerIds,
                project.getTipoContrato(),
                project.getModulo(),
                project.getTipoDemanda(),
                project.getBaseline(),
                project.getValorContrato(),
                piramideVendasService.convertToDTO(project.getPiramideVenda()),
                custoVendaService.convertToDTO(project.getCustoVenda()),
                project.getHorasGestao(),
                project.getBaselineConsumido(),
                project.getInicioContrato(),
                project.getFimContrato(),
                project.getStatus(),
                project.isAtivo()
        );
    }
}
