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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
    , @NamedQuery(name = "Vehiculos.findByIdvehiculos", query = "SELECT v FROM Vehiculos v WHERE v.idvehiculos = :idvehiculos")
    , @NamedQuery(name = "Vehiculos.findByA\u00f1o", query = "SELECT v FROM Vehiculos v WHERE v.a\u00f1o = :a\u00f1o")
    , @NamedQuery(name = "Vehiculos.findByCapacidad", query = "SELECT v FROM Vehiculos v WHERE v.capacidad = :capacidad")
    , @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculos.findByCilindraje", query = "SELECT v FROM Vehiculos v WHERE v.cilindraje = :cilindraje")
    , @NamedQuery(name = "Vehiculos.findByPaisfabri", query = "SELECT v FROM Vehiculos v WHERE v.paisfabri = :paisfabri")
    , @NamedQuery(name = "Vehiculos.findByPlaca", query = "SELECT v FROM Vehiculos v WHERE v.placa = :placa")
    , @NamedQuery(name = "Vehiculos.findByConsecionario", query = "SELECT v FROM Vehiculos v WHERE v.consecionario = :consecionario")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvehiculos")
    private Integer idvehiculos;
    @Size(max = 45)
    @Column(name = "a\u00f1o")
    private String año;
    @Size(max = 45)
    @Column(name = "capacidad")
    private String capacidad;
    @Size(max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "cilindraje")
    private String cilindraje;
    @Size(max = 45)
    @Column(name = "paisfabri")
    private String paisfabri;
    @Size(max = 45)
    @Column(name = "placa")
    private String placa;
    @Size(max = 45)
    @Column(name = "consecionario")
    private String consecionario;

    public Vehiculos() {
    }

    public Vehiculos(Integer idvehiculos) {
        this.idvehiculos = idvehiculos;
    }

    public Integer getIdvehiculos() {
        return idvehiculos;
    }

    public void setIdvehiculos(Integer idvehiculos) {
        this.idvehiculos = idvehiculos;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getPaisfabri() {
        return paisfabri;
    }

    public void setPaisfabri(String paisfabri) {
        this.paisfabri = paisfabri;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getConsecionario() {
        return consecionario;
    }

    public void setConsecionario(String consecionario) {
        this.consecionario = consecionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehiculos != null ? idvehiculos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.idvehiculos == null && other.idvehiculos != null) || (this.idvehiculos != null && !this.idvehiculos.equals(other.idvehiculos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vehiculos[ idvehiculos=" + idvehiculos + " ]";
    }
    
}
