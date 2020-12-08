/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.restfuljersey227.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author kent_chen
 */
public class DataNotFoundExceptionMapper 
        implements ExceptionMapper<DataNotFoundException>{

    @Override
    public Response toResponse(DataNotFoundException arg0) {
        return Response.status(Status.NOT_FOUND).build();
    }
    
}
