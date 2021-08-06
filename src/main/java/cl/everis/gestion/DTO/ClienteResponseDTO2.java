package cl.everis.gestion.DTO;

import cl.everis.gestion.DTO.CuentasResponseDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDTO2 implements Serializable {

    private String rut;
    private String uuid;
    private String nombre;
    private String email;
    //List<ContactoResponseDTO> contacto;
    CuentasResponseDTO cuentas;



}
