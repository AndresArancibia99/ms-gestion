package cl.everis.gestion.service;

import cl.everis.gestion.DTO.ClienteRequestDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO;
import cl.everis.gestion.DTO.ClienteResponseDTO2;
import cl.everis.gestion.DTO.CuentasResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestionServiceImpl implements GestionService{

    private ClienteService clienteService;
    private CuentaService cuentaService;

    public GestionServiceImpl(ClienteService clienteService, CuentaService cuentaService) {
        this.clienteService = clienteService;
        this.cuentaService = cuentaService;
    }

    @Override
    public List<ClienteResponseDTO> buscarClientes() {


        List<ClienteResponseDTO> listaClienteResponseDTO = this.clienteService.listarUsuarios();
        List <CuentasResponseDTO> listaCuentasResponseDTOS = this.cuentaService.listarCuentas();

        return listaClienteResponseDTO.stream()
                .map(cliente-> {

                    List<CuentasResponseDTO> listCuentaResponseDTOS1 = Optional.of(listaCuentasResponseDTOS.stream()
                    .filter(cuentaDTO -> cuentaDTO.getRut().equals(cliente.getRut()))
                    .collect(Collectors.toList()))
                            .orElse(new ArrayList<>());

                    return ClienteResponseDTO.builder()
                            .uuid(cliente.getUuid())
                            .rut(cliente.getRut())
                            .nombre(cliente.getNombre())
                            .email(cliente.getEmail())
                            .cuentas(listCuentaResponseDTOS1)
                            .build();
                }).collect(Collectors.toList());



    }

    @Override
    public ClienteResponseDTO2 listarClientesRut(String rut) {

        ClienteResponseDTO2 clienteResponseDTO2 = this.clienteService.listarCliente(rut);
        this.cuentaService.listarCuenta(rut);
        clienteResponseDTO2.setCuentas(this.cuentaService.listarCuenta(rut));
        return clienteResponseDTO2;
    }


    @Override
    public CuentasResponseDTO listarCuenta(String rut) {
        return this.cuentaService.listarCuenta(rut);
    }


    @Override
    public void insertarClienteCuentas(ClienteRequestDTO clienteRequestDTO) {

        this.clienteService.insertarClienteS(clienteRequestDTO);
        this.cuentaService.insertarCuentasService(clienteRequestDTO);

    }


}
