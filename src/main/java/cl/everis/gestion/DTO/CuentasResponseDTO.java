package cl.everis.gestion.DTO;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CuentasResponseDTO implements Serializable {

    private String rut;
    private long numeroCuenta;
    private List<TipoCuentaResponseDTO> tipoCuenta;
}
