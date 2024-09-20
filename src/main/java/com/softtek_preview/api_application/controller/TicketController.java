package com.softtek_preview.api_application.controller;

import com.softtek_preview.api_application.domain.ticket.TicketRequestDTO;
import com.softtek_preview.api_application.domain.ticket.TicketResponseDTO;
import com.softtek_preview.api_application.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    // Criar um novo ticket
    @PostMapping
    public ResponseEntity<TicketResponseDTO> createTicket(@RequestBody TicketRequestDTO ticketRequestDTO) {
        TicketResponseDTO ticket = ticketService.createTicket(ticketRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    // Obter todos os tickets
    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> getAllTickets() {
        List<TicketResponseDTO> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    // Obter ticket por ID
    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> getTicketById(@PathVariable UUID id) {
        TicketResponseDTO ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    // Atualizar um ticket
    @PutMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> updateTicket(@PathVariable UUID id, @RequestBody TicketRequestDTO ticketRequestDTO) {
        TicketResponseDTO updatedTicket = ticketService.updateTicket(id, ticketRequestDTO);
        return ResponseEntity.ok(updatedTicket);
    }

    // Excluir um ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable UUID id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
