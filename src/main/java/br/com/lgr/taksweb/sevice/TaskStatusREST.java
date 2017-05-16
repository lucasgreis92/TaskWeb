/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lgr.taksweb.sevice;

import br.com.lgr.taksweb.model.Tasks;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Lucas
 */
@Path("taskstatus")
public class TaskStatusREST extends AbstractFacade<Tasks> {

    @PersistenceContext(unitName = "taksPU")
    private EntityManager em;

    public TaskStatusREST() {
        super(Tasks.class);
    }

    /**
     * Retrieves representation of an instance of
     * br.com.lgr.taksweb.sevice.TaskStatusResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{idStatus}")
    @Produces({"application/xml", "application/json"})
    public List<Tasks> findByStatus(@PathParam("idStatus") Integer idStatus) {
        Query query = getEntityManager().createNamedQuery("Tasks.findByIdStatus");
        query.setParameter("idStatus", idStatus);

        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * PUT method for updating or creating an instance of TaskStatusResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
