package entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes", schema = "fp_206_java_con_mysql", catalog = "")
public class Cliente {
    private String email;
    private String nombre;
    private String domicilio;
    private String nif;
    private Integer cuota;
    private Integer descuento;

    @Id
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "domicilio")
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Basic
    @Column(name = "nif")
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Basic
    @Column(name = "cuota")
    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    @Basic
    @Column(name = "descuento")
    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;
        if (nombre != null ? !nombre.equals(cliente.nombre) : cliente.nombre != null) return false;
        if (domicilio != null ? !domicilio.equals(cliente.domicilio) : cliente.domicilio != null) return false;
        if (nif != null ? !nif.equals(cliente.nif) : cliente.nif != null) return false;
        if (cuota != null ? !cuota.equals(cliente.cuota) : cliente.cuota != null) return false;
        if (descuento != null ? !descuento.equals(cliente.descuento) : cliente.descuento != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (cuota != null ? cuota.hashCode() : 0);
        result = 31 * result + (descuento != null ? descuento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", nif='" + nif + '\'' +
                ", cuota=" + cuota +
                ", descuento=" + descuento +
                '}';
    }
}
