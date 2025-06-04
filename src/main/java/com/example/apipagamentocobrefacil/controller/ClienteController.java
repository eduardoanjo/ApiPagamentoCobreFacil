package com.example.apipagamentocobrefacil.controller;

import com.example.apipagamentocobrefacil.api.ClienteAPI;
import com.example.apipagamentocobrefacil.dto.request.NewPFClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.NewPJClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.UpdateClientRequestDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePFResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePJResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClienteResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.UpdateClientResponseDTO;
import com.example.apipagamentocobrefacil.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {

    private final ClientService clientService;

    @Override
    public ResponseEntity<ClienteResponseDTO> allClients() {

        var allClients = clientService.allCLients();

        return ResponseEntity.status(HttpStatus.OK).body(allClients);
    }

    @Override
    public ResponseEntity<ClientePFResponseDTO> createClientPF(NewPFClienteRequestDTO newPFClienteRequestDTO) {
        var created = clientService.createClientPF(newPFClienteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    public ResponseEntity<ClientePJResponseDTO> createClientPJ(NewPJClienteRequestDTO newPJClienteRequestDTO) {
        var created = clientService.createClientPJ(newPJClienteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    public ResponseEntity<ClientePFResponseDTO> clientInfoPF(String id) {
        var clientFound = clientService.clientInfoPF(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }

    @Override
    public ResponseEntity<ClientePJResponseDTO> clientInfoPJ(String id) {
        var clientFound = clientService.clientInfoPJ(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }

    @Override
    public ResponseEntity<Boolean> deleteClient(String id) {
        var deleted = clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

    @Override
    public ResponseEntity<UpdateClientResponseDTO> clientUpdatePF(String id, UpdateClientRequestDTO updateClientRequestDTO) {
        var updated = clientService.clientUpdatePF(id, updateClientRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}
