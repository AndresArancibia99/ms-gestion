package cl.everis.gestion.controller;

import cl.everis.gestion.DTO.ClienteRequestDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO2;
import cl.everis.gestion.DTO.CuentasResponseDTO;
import cl.everis.gestion.service.GestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "")
public class GestionController {

    private GestionService gestionService;




    public GestionController(GestionService gestionService) {
        this.gestionService = gestionService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> buscarGestionClientes(){
        return new ResponseEntity<>(this.gestionService.buscarClientes(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO2> leer(@PathVariable (value = "id") String rut){
        return new ResponseEntity<>(gestionService.listarClientesRut(rut), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> insertarClientesController(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO){
        this.gestionService.insertarClienteCuentas(clienteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
