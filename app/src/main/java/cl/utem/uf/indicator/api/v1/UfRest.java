package cl.utem.uf.indicator.api.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Date;
import org.springframework.http.ResponseEntity;

@Api(value = "/uf", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
public interface UfRest {

    @ApiOperation(value = "Este servicio permite consultar el valor de la UF")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Si existe un valor de la UF para el día"),
        @ApiResponse(code = 401, message = "Si la autenticación fue incorrecta"),
        @ApiResponse(code = 412, message = "Hay error al procesar"),
        @ApiResponse(code = 500, message = "Si hay un error no manejado")

    })
    public ResponseEntity queryUf(@ApiParam(name = "Cabecera con el token") String token, @ApiParam(name = "date") Date date);
}
