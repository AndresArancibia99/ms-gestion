package cl.everis.gestion.service;


import cl.everis.gestion.DTO.ClienteRequestDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO2;
import cl.everis.gestion.DTO.CuentasResponseDTO;

import java.util.List;

public interface GestionService {

    List<ClienteResponseDTO> buscarClientes();
    public ClienteResponseDTO2 listarClientesRut(String rut);
    public CuentasResponseDTO listarCuenta(String rut);
    void insertarClienteCuentas(ClienteRequestDTO clienteRequestDTO);
}
