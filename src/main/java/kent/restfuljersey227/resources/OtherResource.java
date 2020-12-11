/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.restfuljersey227.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author kent_chen
 */
@Path("/others")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class OtherResource {
    
    @GET
    @Path("/context/abspath")
    public String getUriInfo(@Context UriInfo uriInfo) {
        return uriInfo.getAbsolutePath().toString();
    }
    
    @GET
    @Path("/context/request")
    public Response getRequest(@Context Request request) {
        return request.evaluatePreconditions().build();
    }
    
    @GET
    @Path("/query")
    public Response getQueryParam(
            @DefaultValue("-1") @QueryParam("param") String param) {
        String entity;
        Status status;
        
        if (param.equals("-1")){
            entity = "GET request with default param = -1";
            status = Status.OK;
        } else {
            try {
                entity = "GET request with param = " 
                        + Integer.parseInt(param);
                status = Status.OK;
            } catch (NumberFormatException e) {
                entity = "Bad Request: param is expected to be int.";
                status = Status.BAD_REQUEST;
            }
        }
        return Response.status(status)
                .entity(entity)
                .build();
    }
}
