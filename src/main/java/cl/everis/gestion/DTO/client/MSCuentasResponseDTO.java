package cl.everis.gestion.DTO.client;

import cl.everis.gestion.DTO.CuentasResponseDTO;
import cl.everis.gestion.DTO.TipoCuentaResponseDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MSCuentasResponseDTO implements Serializable {

    private String rut;
    private long numeroCuenta;
    private List<TipoCuentaResponseDTO> tipoCuenta;

}
