package cl.everis.gestion.client;

import cl.everis.gestion.DTO.client.MSCuentasRequestDTO;
import cl.everis.gestion.DTO.client.MSCuentasResponseDTO;

import java.util.List;

public interface MSCuentasClient {
    List<MSCuentasResponseDTO> listarCuentas();
    MSCuentasResponseDTO listarCuenta(String id);
    void insertarCuenta(MSCuentasRequestDTO msCuentasRequestDTO);
}
