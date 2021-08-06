package cl.everis.gestion.service;

import cl.everis.gestion.DTO.ClienteRequestDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO2;
import cl.everis.gestion.DTO.client.*;
import cl.everis.gestion.client.MSClientesClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    private MSClientesClient msClientesClient;

    public ClienteServiceImpl(MSClientesClient msClientesClient) {
        this.msClientesClient = msClientesClient;
    }

    @Override
    public List<ClienteResponseDTO> listarUsuarios() {

        return this.msClientesClient.listarClientes().stream()
                .map(msClientes -> ClienteResponseDTO.builder()
                        .rut(msClientes.getRut())
                        .uuid(msClientes.getUuid())
                        .nombre(msClientes.getNombre())
                        .email(msClientes.getEmail())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public void insertarClienteS(ClienteRequestDTO clienteRequestDTO) {


        this.msClientesClient.insertarCliente(MSClienteRequestDTO.builder()
                .rut(clienteRequestDTO.getRut())
                .nombre(clienteRequestDTO.getNombre())
                .email(clienteRequestDTO.getEmail())
                .pwd(clienteRequestDTO.getPwd())
                .build());
    }

    @Override
    public ClienteResponseDTO2 listarCliente(String id) {

        MSClienteResponseDTO msClienteResponseDTO = this.msClientesClient.listarCliente(id);
        ClienteResponseDTO2 clienteResponseDTO2 =
                ClienteResponseDTO2.builder()
                        .rut(msClienteResponseDTO.getRut())
                        .nombre(msClienteResponseDTO.getNombre())
                        .uuid(msClienteResponseDTO.getUuid())
                        .email(msClienteResponseDTO.getEmail())
                        .build();


        return clienteResponseDTO2;
    }
}

