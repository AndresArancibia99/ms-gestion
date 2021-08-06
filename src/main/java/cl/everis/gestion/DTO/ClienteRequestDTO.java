package cl.everis.gestion.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestDTO implements Serializable {

    private String rut;
    private String nombre;
    private String email;
    private String pwd;
    //private List<ContactoRequestDTO> contacto;
    private List<CuentasRequestDTO> cuentas;



}
