package cl.everis.gestion.DTO.client;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MSTipoCuentasRequestDTO implements Serializable {

    private String tipodeCuenta;
    private String descripcionCuenta;

}
