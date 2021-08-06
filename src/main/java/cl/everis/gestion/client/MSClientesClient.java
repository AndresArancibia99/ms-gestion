package cl.everis.gestion.client;

import cl.everis.gestion.DTO.client.MSClienteRequestDTO;
import cl.everis.gestion.DTO.client.MSClienteResponseDTO;

import java.util.List;

public interface MSClientesClient {

    List<MSClienteResponseDTO> listarClientes();
    MSClienteResponseDTO listarCliente(String id);
    void insertarCliente(MSClienteRequestDTO msClienteRequestDTO);

}
