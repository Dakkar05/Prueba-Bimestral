/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santiago
 */
@Entity
@Table(name = "mantenimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimientos.findAll", query = "SELECT m FROM Mantenimientos m")
    , @NamedQuery(name = "Mantenimientos.findByIdmantenimientos", query = "SELECT m FROM Mantenimientos m WHERE m.idmantenimientos = :idmantenimientos")
    , @NamedQuery(name = "Mantenimientos.findByVehiculo", query = "SELECT m FROM Mantenimientos m WHERE m.vehiculo = :vehiculo")
    , @NamedQuery(name = "Mantenimientos.findByIdcliente", query = "SELECT m FROM Mantenimientos m WHERE m.idcliente = :idcliente")
    , @NamedQuery(name = "Mantenimientos.findByFecha", query = "SELECT m FROM Mantenimientos m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mantenimientos.findByDescripcion", query = "SELECT m FROM Mantenimientos m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Mantenimientos.findByKilometraje", query = "SELECT m FROM Mantenimientos m WHERE m.kilometraje = :kilometraje")})
public class Mantenimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmantenimientos")
    private Integer idmantenimientos;
    @Size(max = 45)
    @Column(name = "vehiculo")
    private String vehiculo;
    @Column(name = "idcliente")
    private Integer idcliente;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "kilometraje")
    private String kilometraje;

    public Mantenimientos(Integer idmantenimientos, String vehiculo, Integer idcliente, String fecha, String descripcion, String kilometraje) {
        this.idmantenimientos = idmantenimientos;
        this.vehiculo = vehiculo;
        this.idcliente = idcliente;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.kilometraje = kilometraje;
    }

    
    
    
    public Mantenimientos() {
    }

    public Mantenimientos(Integer idmantenimientos) {
        this.idmantenimientos = idmantenimientos;
    }

    public Integer getIdmantenimientos() {
        return idmantenimientos;
    }

    public void setIdmantenimientos(Integer idmantenimientos) {
        this.idmantenimientos = idmantenimientos;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmantenimientos != null ? idmantenimientos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimientos)) {
            return false;
        }
        Mantenimientos other = (Mantenimientos) object;
        if ((this.idmantenimientos == null && other.idmantenimientos != null) || (this.idmantenimientos != null && !this.idmantenimientos.equals(other.idmantenimientos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Mantenimientos[ idmantenimientos=" + idmantenimientos + " ]";
    }
    
}
