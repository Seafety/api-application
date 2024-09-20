package com.softtek_preview.api_application.service;

import com.softtek_preview.api_application.domain.consultant.Consultant;
import com.softtek_preview.api_application.domain.project.Project;
import com.softtek_preview.api_application.domain.ticket.Ticket;
import com.softtek_preview.api_application.domain.ticket.TicketRequestDTO;
import com.softtek_preview.api_application.domain.ticket.TicketResponseDTO;
import com.softtek_preview.api_application.exceptions.ResourceNotFoundException;
import com.softtek_preview.api_application.repositories.ConsultantRepository;
import com.softtek_preview.api_application.repositories.ProjectRepository;
import com.softtek_preview.api_application.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ConsultantRepository consultantRepository;

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = convertToEntity(ticketRequestDTO);
        Ticket savedTicket = ticketRepository.save(ticket);
        return convertToDTO(savedTicket);
    }

    public List<TicketResponseDTO> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TicketResponseDTO getTicketById(UUID id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        return convertToDTO(ticket);
    }

    public TicketResponseDTO updateTicket(UUID id, TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        updateFromDTO(ticket, ticketRequestDTO);
        Ticket updatedTicket = ticketRepository.save(ticket);
        return convertToDTO(updatedTicket);
    }

    public void deleteTicket(UUID id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        ticketRepository.delete(ticket);
    }

    private void updateFromDTO(Ticket ticket, TicketRequestDTO dto) {
        ticket.setChamado(dto.chamado());
        ticket.setDtAberturaChamado(dto.dtAberturaChamado());
        ticket.setModuloChamado(dto.moduloChamado());
        ticket.setTipoChamado(dto.tipoChamado());
        ticket.setStatusChamado(dto.statusChamado());
        ticket.setExercicio(dto.exercicio());
        ticket.setPeriodo(dto.periodo());
        ticket.setDia(dto.dia());
        ticket.setHoras(dto.horas());
        ticket.setTipoHoras(dto.tipoHoras());
        ticket.setComplexidade(dto.complexidade());

        Project project = projectRepository.findById(dto.projetoId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        ticket.setProjeto(project);

        Consultant consultant = consultantRepository.findById(dto.consultantId())
                .orElseThrow(() -> new ResourceNotFoundException("Consultant not found"));
        ticket.setConsultant(consultant);
    }

    private Ticket convertToEntity(TicketRequestDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setChamado(dto.chamado());
        ticket.setDtAberturaChamado(dto.dtAberturaChamado());
        ticket.setModuloChamado(dto.moduloChamado());
        ticket.setTipoChamado(dto.tipoChamado());
        ticket.setStatusChamado(dto.statusChamado());
        ticket.setExercicio(dto.exercicio());
        ticket.setPeriodo(dto.periodo());
        ticket.setDia(dto.dia());
        ticket.setHoras(dto.horas());
        ticket.setTipoHoras(dto.tipoHoras());
        ticket.setComplexidade(dto.complexidade());

        Project project = projectRepository.findById(dto.projetoId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        ticket.setProjeto(project);

        Consultant consultant = consultantRepository.findById(dto.consultantId())
                .orElseThrow(() -> new ResourceNotFoundException("Consultant not found"));
        ticket.setConsultant(consultant);

        return ticket;
    }

    private TicketResponseDTO convertToDTO(Ticket ticket) {
        return new TicketResponseDTO(
                ticket.getId(),  // UUID id
                ticket.getProjeto().getId(),  // UUID projetoId
                ticket.getProjeto().getDescricao(),  // String projetoNome
                ticket.getChamado(),  // int chamado
                ticket.getDtAberturaChamado(),  // LocalDate dtAberturaChamado
                ticket.getModuloChamado(),  // String moduloChamado
                ticket.getTipoChamado(),  // String tipoChamado
                ticket.getStatusChamado(),  // String statusChamado
                ticket.getConsultant().getId(),  // UUID consultantId
                ticket.getConsultant().getNome(),  // String consultantNome
                ticket.getModuloConsultor(),  // String moduloConsultor
                ticket.getExercicio(),  // int exercicio
                ticket.getPeriodo(),  // int periodo
                ticket.getDia(),  // int dia
                ticket.getHoras(),  // int horas
                ticket.getTipoHoras(),  // String tipoHoras
                ticket.getComplexidade()  // String complexidade
        );
    }

}