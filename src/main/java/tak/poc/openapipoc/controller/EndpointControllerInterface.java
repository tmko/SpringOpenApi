package tak.poc.openapipoc.controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tak.poc.openapipoc.ApplicationConstant;

import java.util.List;

@RequestMapping(path = ApplicationConstant.CONTEXT_PATH)
@OpenAPIDefinition(
        info = @Info( title = ApplicationConstant.API_NAME, version = ApplicationConstant.API_VERSION ),
        security = @SecurityRequirement(name = ApplicationConstant.GSK)
)
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = ApplicationConstant.GSK,  in = SecuritySchemeIn.HEADER)


public interface EndpointControllerInterface {


    @GetMapping("/queryInfo")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", content={ @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode="400", content={ @Content(mediaType = "application/json")}, description = "> 3")
    })
    List<InfoItem> queryFakeInfo (
            Authentication authentication,

            @RequestParam(required = false, defaultValue = "3")
            @Parameter(description = "custom description for this parameter.")
                    int count
    );


    @PutMapping("/updateInfo")
    void updateInfo (
        Authentication authentication,

        @RequestParam int id,
        @RequestBody InfoItem input
    );
}