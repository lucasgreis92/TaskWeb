/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lgr.taksweb.sevice;

import br.com.lgr.taksweb.model.Tasks;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Lucas
 */
@Stateless
@Path("tasks")
public class TasksFacadeREST extends AbstractFacade<Tasks> {

    @PersistenceContext(unitName = "taksPU")
    private EntityManager em;

    public TasksFacadeREST() {
        super(Tasks.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Tasks entity) {
        if (entity.getId() == null) {
            entity.setDtCriacao(new Date());
            super.create(entity);
        } else {
            entity.setDtEdicao(new Date());
            super.edit(entity);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        Tasks task = super.find(id);
        task.setDtExclusao(new Date());
        super.edit(task);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Tasks find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Tasks> findAll() {
        //return super.findAll();
        Query query = getEntityManager().createNamedQuery("Tasks.findAll");
        return query.getResultList();

    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Tasks> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
