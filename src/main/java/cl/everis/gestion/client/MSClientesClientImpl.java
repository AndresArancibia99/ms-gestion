package cl.everis.gestion.client;

import cl.everis.gestion.DTO.client.MSClienteRequestDTO;
import cl.everis.gestion.DTO.client.MSClienteResponseDTO;
import cl.everis.gestion.exception.ErrorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class MSClientesClientImpl implements MSClientesClient {

    private RestTemplate restTemplate;

    @Value("${url.clientes}")
    private String urlClientes;

    public MSClientesClientImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public List<MSClienteResponseDTO> listarClientes() {

        try {


            UriComponents uri = UriComponentsBuilder.fromUriString(this.urlClientes)
                    .path("usuarios")
                    .buildAndExpand();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity entity = new HttpEntity(headers);

            ResponseEntity<List<MSClienteResponseDTO>> responseEntity =
                    this.restTemplate
                            .exchange(uri.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<MSClienteResponseDTO>>() {
                            });
            return responseEntity.getBody();
        }catch (HttpClientErrorException e){
            throw new ErrorException(HttpStatus.BAD_REQUEST, "Problema Peticion");
        }catch (HttpServerErrorException ex){
            throw new ErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Problema con el Servidor");
        }   catch (Exception exc){
            throw new ErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Problema con la conexion");
        }



    }

    @Override
    public MSClienteResponseDTO listarCliente(String id) {

        UriComponents uri = UriComponentsBuilder.fromUriString(this.urlClientes)
                .path("usuarios/{rut}")
                .buildAndExpand(id);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<MSClienteResponseDTO> responseEntity =
                this.restTemplate.exchange(uri.toString(), HttpMethod.GET, null, MSClienteResponseDTO.class);
        return responseEntity.getBody();
    }


    @Override
    public void insertarCliente(MSClienteRequestDTO msClienteRequestDTO) {

        UriComponents uri = UriComponentsBuilder.fromUriString(this.urlClientes)
                .path("usuarios")
                .buildAndExpand();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(msClienteRequestDTO, headers);

        ResponseEntity <Void> responseEntity =
                this.restTemplate
                        .exchange(uri.toString(), HttpMethod.POST, entity, Void.class);

    }
}
