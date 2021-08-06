package cl.everis.gestion.service;

import cl.everis.gestion.DTO.ClienteRequestDTO;
import cl.everis.gestion.DTO.CuentasResponseDTO;

import java.util.List;

public interface CuentaService {

    List<CuentasResponseDTO> listarCuentas();
    void insertarCuentasService(ClienteRequestDTO clienteRequestDTO);
    CuentasResponseDTO listarCuenta(String id);
}
