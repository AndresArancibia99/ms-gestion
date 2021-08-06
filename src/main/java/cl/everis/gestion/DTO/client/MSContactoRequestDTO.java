package cl.everis.gestion.DTO.client;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MSContactoRequestDTO implements Serializable {

    private String numero;
    private String codigoCiudad;
    private String codigoPais;

}
