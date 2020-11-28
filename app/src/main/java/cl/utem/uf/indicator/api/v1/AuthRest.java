package cl.utem.uf.indicator.api.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(value = "/auth", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
public interface AuthRest {

    @ApiOperation(value = "Este servicio permite la comunicación entre la aplicación y la autenticación con Google")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Si la autenticación fue correcta"),
        @ApiResponse(code = 401, message = "Si la autenticación fue incorrecta"),
        @ApiResponse(code = 412, message = "No se entiende o hay error al procesar"),
        @ApiResponse(code = 500, message = "Si hay un error no manejado")

    })
    public ResponseEntity googleCallback(@ApiParam("state") String state, @ApiParam("code") String code);

}
