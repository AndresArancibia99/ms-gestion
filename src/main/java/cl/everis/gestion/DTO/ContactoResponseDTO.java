package cl.everis.gestion.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactoResponseDTO {

    private String numero;

    private String codigoCiudad;

    private String codigoPais;
}
