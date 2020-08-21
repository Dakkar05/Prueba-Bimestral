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
import modelo.Cliente;

/**
 *
 * @author santiago
 */
@Stateless
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "Evaluacion_BimestrePU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
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
    public Cliente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("crearcli")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crearCli(@FormParam("idcliente")int idcliente,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido,@FormParam("cedula")String cedula,@FormParam("dereccion")String direccion,@FormParam("edad")String edad,@FormParam("provincia")String provincia,@FormParam("vehiculo")String vehiculo){
    Cliente ob = new Cliente (idcliente,nombre,apellido,cedula,direccion,edad,provincia,vehiculo);
    super.create(ob);
    return "El cliente se registro con Exito";
    }
    
    @POST
    @Path("editarcli")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idcliente")int idcliente,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido,@FormParam("cedula")String cedula,@FormParam("dereccion")String direccion,@FormParam("edad")String edad,@FormParam("provincia")String provincia,@FormParam("vehiculo")String vehiculo){
    Cliente ob = super.find(idcliente);
    
    ob.setApellido(apellido);
    ob.setCedula(cedula);
    ob.setDireccion(direccion);
    ob.setEdad(edad);
    ob.setIdcliente(idcliente);
    ob.setNombre(nombre);
    ob.setProviciaproced(provincia);
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
