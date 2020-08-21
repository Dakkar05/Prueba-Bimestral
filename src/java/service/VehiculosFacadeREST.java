/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Vehiculos;

/**
 *
 * @author santiago
 */
@Stateless
@Path("modelo.vehiculos")
public class VehiculosFacadeREST extends AbstractFacade<Vehiculos> {

    @PersistenceContext(unitName = "Evaluacion_BimestrePU")
    private EntityManager em;

    public VehiculosFacadeREST() {
        super(Vehiculos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vehiculos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vehiculos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Vehiculos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("crearvehi")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crearCli(@FormParam("idvehiculos")int idvehiculos,@FormParam("año")String a\u00f1o,@FormParam("capacidad")String capacidad,@FormParam("modelo")String modelo,@FormParam("marca")String marca,@FormParam("cilindraje")String cilindraje,@FormParam("paisfabri")String paisfabri,@FormParam("placa")String placa,@FormParam("consercionario")String consecionario){
    Vehiculos ob = new Vehiculos (idvehiculos,año,capacidad,modelo,marca,cilindraje,paisfabri,placa,consecionario);
    super.create(ob);
    return "El cliente se registro con Exito";
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
