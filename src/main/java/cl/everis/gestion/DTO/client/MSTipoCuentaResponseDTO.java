package cl.everis.gestion.DTO.client;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MSTipoCuentaResponseDTO {

    private int idTipoCuenta;
    private String tipoCuenta;
    private String descripcionCuenta;

}
