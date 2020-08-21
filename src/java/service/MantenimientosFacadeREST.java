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
import modelo.Mantenimientos;

/**
 *
 * @author santiago
 */
@Stateless
@Path("modelo.mantenimientos")
public class MantenimientosFacadeREST extends AbstractFacade<Mantenimientos> {

    @PersistenceContext(unitName = "Evaluacion_BimestrePU")
    private EntityManager em;

    public MantenimientosFacadeREST() {
        super(Mantenimientos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Mantenimientos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Mantenimientos entity) {
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
    public Mantenimientos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mantenimientos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mantenimientos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("crearmant")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crearCli(@FormParam("idmantenimiento")int idmantenimiento,@FormParam("vehiculo")String vehiculo,@FormParam("idcliente")int idcliente,@FormParam("fecha")String fecha,@FormParam("descripcion")String descripcion,@FormParam("kilometraje")String kilometraje){
    Mantenimientos ob = new Mantenimientos (idmantenimiento,vehiculo,idcliente,fecha,descripcion,kilometraje);
    super.create(ob);
    return "El cliente se registro con Exito";
    }
    
    @POST
    @Path("editarmant")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idmantenimiento")int idmantenimiento,@FormParam("vehiculo")String vehiculo,@FormParam("idcliente")int idcliente,@FormParam("fecha")String fecha,@FormParam("descripcion")String descripcion,@FormParam("kilometraje")String kilometraje){
    Mantenimientos ob = super.find(idmantenimiento);
    ob.setDescripcion(descripcion);
    ob.setFecha(fecha);
    ob.setIdcliente(idcliente);
    ob.setIdmantenimientos(idmantenimiento);
    ob.setKilometraje(kilometraje);
    ob.setVehiculo(vehiculo);
    if(ob== null){
            return "no se encuentra el id";
        }else{
             super.edit(ob);
            return "Se edito correctamente";
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
