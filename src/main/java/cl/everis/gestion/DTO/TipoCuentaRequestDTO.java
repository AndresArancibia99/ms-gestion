package cl.everis.gestion.DTO;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoCuentaRequestDTO implements Serializable {


    private String tipoCuenta;

    private String descripcionCuenta;

}
