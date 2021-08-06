package cl.everis.gestion.service;

import cl.everis.gestion.DTO.ClienteRequestDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO2;

import java.util.List;

public interface ClienteService {

    List<ClienteResponseDTO> listarUsuarios();
    void insertarClienteS(ClienteRequestDTO clienteRequestDTO);
    ClienteResponseDTO2 listarCliente(String id);
}
