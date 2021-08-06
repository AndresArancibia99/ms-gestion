package cl.everis.gestion.DTO;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactoRequestDTO implements Serializable {

    private int idContacto;

    private String numero ;

    private String codigoCiudad;

    private String codigoPais;

}
