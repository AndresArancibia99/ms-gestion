package cl.everis.gestion.DTO;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentasRequestDTO {

    private String rut;
    private long numeroCuenta;
    private List<TipoCuentaRequestDTO> tipoCuenta;

}
