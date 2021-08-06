package cl.everis.gestion.DTO.client;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MSCuentasRequestDTO {

    private String rut;
    private long numeroCuenta;
    private List<MSTipoCuentasRequestDTO> tipoCuenta;
}
