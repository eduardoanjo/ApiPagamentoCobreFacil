package com.example.apipagamentocobrefacil.service;


import com.example.apipagamentocobrefacil.dto.request.NewPFClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.NewPJClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.UpdateClientRequestDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePFResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePJResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClienteResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.UpdateClientResponseDTO;

public interface ClientService {

    ClienteResponseDTO allCLients();

    ClientePFResponseDTO createClientPF(NewPFClienteRequestDTO newPFClienteRequestDTO);
    ClientePJResponseDTO createClientPJ(NewPJClienteRequestDTO newPJClienteRequestDTO);

    ClientePFResponseDTO clientInfoPF(String id);
    ClientePJResponseDTO clientInfoPJ(String id);

    Boolean deleteClient(String id);

    UpdateClientResponseDTO clientUpdatePF(String id, UpdateClientRequestDTO updateClientRequestDTO);
}
