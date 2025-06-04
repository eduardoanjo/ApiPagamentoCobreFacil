package com.example.apipagamentocobrefacil.converter;

import com.example.apipagamentocobrefacil.dto.UpdateClientDTO;
import com.example.apipagamentocobrefacil.dto.request.NewPFClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.NewPJClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.UpdateClientRequestDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePFResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePJResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.UpdateClientResponseDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request.CF_NewClientPFRequestDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request.CF_NewClientPJRequestDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.request.CF_UpdateClientRequestDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.model.CF_Cliente_PF;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.model.CF_Cliente_PJ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteConverter {

    ClientePFResponseDTO toClientePFResponseDTO(CF_Cliente_PF cfClientePf);
    ClientePJResponseDTO toClientePJResponseDTO(CF_Cliente_PJ cfClientePj);

    CF_NewClientPFRequestDTO toCFNewCLientPF(NewPFClienteRequestDTO newClienteRequestDTO);
    ClientePFResponseDTO toNewCLientPFResponse(CF_Cliente_PF clienteResponseDTO);

    CF_NewClientPJRequestDTO toCFNewCLientPJ(NewPJClienteRequestDTO newClienteRequestDTO);
    ClientePJResponseDTO toNewCLientPJResponse(CF_Cliente_PJ clienteResponseDTO);

    CF_UpdateClientRequestDTO toCFUpdateClientRequestDTO(UpdateClientRequestDTO updateClientRequestDTO);
    UpdateClientResponseDTO toUpdateClientResponseDTO(UpdateClientDTO updateClientRequestDTO);

}
