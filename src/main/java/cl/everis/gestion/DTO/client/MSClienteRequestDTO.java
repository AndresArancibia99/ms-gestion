package cl.everis.gestion.DTO.client;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MSClienteRequestDTO {

    private String rut;
    private String nombre;
    private String email;
    private String pwd;
    //List<MSContactoRequestDTO> contacto;
}
