package cl.everis.gestion.client;

import cl.everis.gestion.DTO.client.MSCuentasRequestDTO;
import cl.everis.gestion.DTO.client.MSCuentasResponseDTO;
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
public class MSCuentasClientImpl implements MSCuentasClient{
    private RestTemplate restTemplate;

    @Value("${url.cuentas}")
    private String urlCuentas;

    public MSCuentasClientImpl (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public List<MSCuentasResponseDTO> listarCuentas() {
        try {
        UriComponents uri = UriComponentsBuilder.fromUriString(this.urlCuentas)
                .path("cuentas")
                .buildAndExpand();


        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<MSCuentasResponseDTO>> responseEntity =
                this.restTemplate
                .exchange(uri.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<MSCuentasResponseDTO>>() {
                });

        return responseEntity.getBody();
        }catch (HttpClientErrorException e){
            throw new ErrorException(HttpStatus.BAD_REQUEST, "Problema Peticion");
        }catch (HttpServerErrorException ex){
            throw new ErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Problema con el Servidor");
        }  catch (Exception exc){
            throw new ErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Problema con la conexion");
        }
    }


    @Override
    public MSCuentasResponseDTO listarCuenta(String id) {

        UriComponents uri = UriComponentsBuilder.fromUriString(this.urlCuentas)
                .path("cuentas/{rut}")
                .buildAndExpand(id);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

       ResponseEntity<MSCuentasResponseDTO> responseEntity =
              this.restTemplate.exchange(uri.toString(), HttpMethod.GET, null, MSCuentasResponseDTO.class);
        return responseEntity.getBody();
    }

    @Override
    public void insertarCuenta(MSCuentasRequestDTO msCuentasRequestDTO) {


        UriComponents uri = UriComponentsBuilder.fromUriString(this.urlCuentas)
                .path("cuentas")
                .buildAndExpand();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(msCuentasRequestDTO, headers);

        ResponseEntity<Void> responseEntity =
                this.restTemplate
                        .exchange(uri.toString(), HttpMethod.POST, entity, Void.class);

    }
}
