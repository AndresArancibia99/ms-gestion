package cl.everis.gestion.service;


import cl.everis.gestion.DTO.ClienteRequestDTO;
import cl.everis.gestion.DTO.CuentasRequestDTO;
import cl.everis.gestion.DTO.CuentasResponseDTO;
import cl.everis.gestion.DTO.client.*;
import cl.everis.gestion.client.MSClientesClient;
import cl.everis.gestion.client.MSCuentasClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaServiceImpl implements CuentaService {

    private MSCuentasClient msCuentasClient;

    public CuentaServiceImpl(MSCuentasClient msCuentasClient) {
        this.msCuentasClient = msCuentasClient;
    }


    @Override
    public List<CuentasResponseDTO> listarCuentas() {


        return this.msCuentasClient.listarCuentas().stream()
                .map(msCuentas -> CuentasResponseDTO.builder()
                        .numeroCuenta(msCuentas.getNumeroCuenta())
                        .rut(msCuentas.getRut())
                        .tipoCuenta(msCuentas.getTipoCuenta())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public void insertarCuentasService(ClienteRequestDTO clienteRequestDTO) {



        for (int i = 0; i < clienteRequestDTO.getCuentas().size(); i++) {
            List<MSTipoCuentasRequestDTO> msTipoCuentasRequestDTOS =
                    clienteRequestDTO.getCuentas().get(i).getTipoCuenta().stream()
                            .map(tipoCuenta -> MSTipoCuentasRequestDTO.builder()
                                    .tipodeCuenta(tipoCuenta.getTipoCuenta())
                                    .descripcionCuenta(tipoCuenta.getDescripcionCuenta())
                                    .build())
                            .collect(Collectors.toList());


            this.msCuentasClient.insertarCuenta(MSCuentasRequestDTO.builder()
                    .rut(clienteRequestDTO.getCuentas().get(i).getRut())
                    .numeroCuenta(clienteRequestDTO.getCuentas().get(i).getNumeroCuenta())
                    .tipoCuenta(msTipoCuentasRequestDTOS)
                    .build());
        }


    }

    @Override
    public CuentasResponseDTO listarCuenta(String id) {
        MSCuentasResponseDTO msCuentasResponseDTO = this.msCuentasClient.listarCuenta(id);
        CuentasResponseDTO cuentasResponseDTO =
                CuentasResponseDTO.builder()
                        .rut(msCuentasResponseDTO.getRut())
                        .numeroCuenta(msCuentasResponseDTO.getNumeroCuenta())
                        .tipoCuenta(msCuentasResponseDTO.getTipoCuenta())
                        .build();

        return cuentasResponseDTO;
    }
}
