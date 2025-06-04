package com.example.apipagamentocobrefacil.api;

import com.example.apipagamentocobrefacil.dto.request.NewPFClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.NewPJClienteRequestDTO;
import com.example.apipagamentocobrefacil.dto.request.UpdateClientRequestDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePFResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClientePJResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.ClienteResponseDTO;
import com.example.apipagamentocobrefacil.dto.response.UpdateClientResponseDTO;
import feign.Headers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Headers("Content-Type: application/json")
@Tag(name = "Api de Cliente", description = "Api de gestão cliente")
@RequestMapping( value = "/client", produces = "application/json")
public interface ClienteAPI {

    @GetMapping("/allClients")
    @Operation(summary = "Buscar todos os clientes cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "401", description = "Autenticação inválida."),
            @ApiResponse(responseCode = "404", description = "Não encontrado."),
            @ApiResponse(responseCode = "429", description = "Muitas requisições em andamento, tente mais tarde."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor ou serviço") })
    ResponseEntity<ClienteResponseDTO> allClients();


    @PostMapping("/create_pf")
    @Operation(summary = "Criar um novo cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "401", description = "Autenticação inválida."),
            @ApiResponse(responseCode = "404", description = "Não encontrado."),
            @ApiResponse(responseCode = "429", description = "Muitas requisições em andamento, tente mais tarde."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor ou serviço") })
    ResponseEntity<ClientePFResponseDTO> createClientPF(@RequestBody @Valid NewPFClienteRequestDTO newPFClienteRequestDTO);

    @PostMapping("/create_pj")
    @Operation(summary = "Criar um novo cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "401", description = "Autenticação inválida."),
            @ApiResponse(responseCode = "404", description = "Não encontrado."),
            @ApiResponse(responseCode = "429", description = "Muitas requisições em andamento, tente mais tarde."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor ou serviço") })
    ResponseEntity<ClientePJResponseDTO> createClientPJ(@Valid @RequestBody NewPJClienteRequestDTO newPJClienteRequestDTO);

    @GetMapping("/pf/{id}")
    @Operation(summary = "Buscar info de um cliente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "401", description = "Autenticação inválida."),
            @ApiResponse(responseCode = "404", description = "Não encontrado."),
            @ApiResponse(responseCode = "429", description = "Muitas requisições em andamento, tente mais tarde."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor ou serviço") })
    ResponseEntity<ClientePFResponseDTO> clientInfoPF(@PathVariable(value = "id") String id);

    @GetMapping("/pj/{id}")
    @Operation(summary = "Buscar info de um cliente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "401", description = "Autenticação inválida."),
            @ApiResponse(responseCode = "404", description = "Não encontrado."),
            @ApiResponse(responseCode = "429", description = "Muitas requisições em andamento, tente mais tarde."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor ou serviço") })
    ResponseEntity<ClientePJResponseDTO> clientInfoPJ(@PathVariable(value = "id") String id);

    @DeleteMapping("/{id}")
    @Operation(summary = "Buscar info de um cliente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "401", description = "Autenticação inválida."),
            @ApiResponse(responseCode = "404", description = "Não encontrado."),
            @ApiResponse(responseCode = "429", description = "Muitas requisições em andamento, tente mais tarde."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor ou serviço") })
    ResponseEntity<Boolean> deleteClient(@PathVariable(value = "id") String id);

    @PutMapping("/pf/{id}")
    @Operation(summary = "Update info de um cliente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "401", description = "Autenticação inválida."),
            @ApiResponse(responseCode = "404", description = "Não encontrado."),
            @ApiResponse(responseCode = "429", description = "Muitas requisições em andamento, tente mais tarde."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor ou serviço") })
    ResponseEntity<UpdateClientResponseDTO> clientUpdatePF(@PathVariable(value = "id") String id, @Valid @RequestBody UpdateClientRequestDTO updateClientRequestDTO);
}