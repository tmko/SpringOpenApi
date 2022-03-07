package tak.poc.openapipoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenApiPocApplication {

    /**
     * mvn spring-boot:build-info spring-boot:run
     * curl -X PUT -H 'Content-Type: application/json' http://localhost:8080/greet -d '{ "name" : "Tak" }'
     * curl -X GET -H 'Content-Type: application/json' http://localhost:8080/intel/health
     * curl -X GET -H 'Content-Type: application/json' http://localhost:8080/intel/info
     * curl -X GET http://localhost:8080/v3/api-docs
     * curl -X GET http://localhost:8080/v3/api-docs.yaml
     * curl -X GET http://localhost:8080/swagger-ui/index.html
     **/
    public static void main(String[] args) {
        SpringApplication.run(OpenApiPocApplication.class, args);
    }

}



