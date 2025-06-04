package com.example.apipagamentocobrefacil.service.impl;

import com.example.apipagamentocobrefacil.converter.ClienteConverter;
import com.example.apipagamentocobrefacil.dto.request.NewPFClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.NewPJClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.UpdateClientRequestDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePFResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePJResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClienteResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.UpdateClientResponseDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.CobreFacilClient;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.dto.response.CF_NewClienteResponseDTO;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.model.CF_Cliente_PF;
import com.example.apipagamentocobrefacil.gateway.cobrefacil.model.CF_Cliente_PJ;
import com.example.apipagamentocobrefacil.service.ClientService;
import com.federasys.pagamentofederacao.utils.Constante;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final CobreFacilClient cobreFacilClient;
    private final ClienteConverter clienteConverter;

    @Override
    public ClienteResponseDTO allCLients() {

        var response = cobreFacilClient.clients();
        var data = response.getData();

        var clienteResponseDTO = new ClienteResponseDTO();
        var listaPF = new ArrayList<ClientePFResponseDTO>(0);
        var listaPJ = new ArrayList<ClientePJResponseDTO>(0);

        data.forEach(cfCliente -> {
            if (cfCliente instanceof CF_Cliente_PF cfClientePf) {
                listaPF.add(clienteConverter.toClientePFResponseDTO(cfClientePf));
            } else {
                listaPJ.add(clienteConverter.toClientePJResponseDTO((CF_Cliente_PJ) cfCliente));
            }
        });

        clienteResponseDTO.setClientsPF(listaPF);
        clienteResponseDTO.setClientsPJ(listaPJ);

        return clienteResponseDTO;
    }

    @Override
    public ClientePFResponseDTO createClientPF(NewPFClienteRequestDTO newPFClienteRequestDTO) {
        var converted = clienteConverter.toCFNewCLientPF(newPFClienteRequestDTO);
        converted.setPersonType(Constante.PERSON_TYPE_PF);

        var response = cobreFacilClient.newClientPF(converted);
        var clientCreated = response.getData();

        return clienteConverter.toNewCLientPFResponse((CF_Cliente_PF) clientCreated);
    }

    @Override
    public ClientePJResponseDTO createClientPJ(NewPJClienteRequestDTO newPJClienteRequestDTO) {
        var converted = clienteConverter.toCFNewCLientPJ(newPJClienteRequestDTO);
        converted.setPersonType(Constante.PERSON_TYPE_PJ);

        var response = cobreFacilClient.newClientPJ(converted);
        var clientCreated = response.getData();

        return clienteConverter.toNewCLientPJResponse((CF_Cliente_PJ) clientCreated);
    }

    @Override
    public ClientePFResponseDTO clientInfoPF(String id) {
        var response = findClient(id);
        var clientFound = response.getData();

        if (clientFound instanceof CF_Cliente_PF cfClientePf) {
            return clienteConverter.toClientePFResponseDTO(cfClientePf);
        } else {
            throw new EntityNotFoundException("Cliente PF não encontrado");
        }
    }

    @Override
    public ClientePJResponseDTO clientInfoPJ(String id) {
        var response = findClient(id);
        var clientFound = response.getData();

        if (clientFound instanceof CF_Cliente_PF cfClientePf) {
            throw new EntityNotFoundException("Cliente PJ não encontrado");
        } else {
            return clienteConverter.toClientePJResponseDTO((CF_Cliente_PJ) clientFound);
        }
    }

    @Override
    public Boolean deleteClient(String id) {
        var response = cobreFacilClient.deleteClient(id);
        return response.isSuccess();
    }

    @Override
    public UpdateClientResponseDTO clientUpdatePF(String id, UpdateClientRequestDTO updateClientRequestDTO) {
        var convertedToUpdate = clienteConverter.toCFUpdateClientRequestDTO(updateClientRequestDTO);
        var response = cobreFacilClient.updateClient(id, convertedToUpdate);
        var updated = response.getData();
        return clienteConverter.toUpdateClientResponseDTO(updated);
    }

    private CF_NewClienteResponseDTO findClient(String id) {
        return cobreFacilClient.clientInfo(id);
    }

}
