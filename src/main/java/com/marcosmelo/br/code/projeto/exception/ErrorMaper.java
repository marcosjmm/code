package com.marcosmelo.br.code.projeto.exception;

import javax.json.Json;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErrorMaper implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception exception) {
		if(exception instanceof ProjetoException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Json.createObjectBuilder().add("mensagem", exception.getMessage()).add("status", Response.Status.NOT_FOUND.getStatusCode()).build())
                    .build();
        }
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Json.createObjectBuilder().add("mensagem", "Tente novamente. "+exception.getMessage()).add("status", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build())
                .build();
	}
	
	public static final class ErrorResponseBody {

        private final String message;

        public ErrorResponseBody(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
