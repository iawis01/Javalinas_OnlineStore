package entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes", schema = "fp_206_java_con_mysql", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
        @NamedQuery(name = "Cliente.findAllEstandar", query = "SELECT c FROM Cliente c WHERE c.cuota = 0"),
        @NamedQuery(name = "Cliente.findAllPremium", query = "SELECT c FROM Cliente c WHERE c.cuota = 30")
})
public class Cliente {
    private String email;
    private String nombre;
    private String domicilio;
    private String nif;
    private int cuota;
    private int descuento;

    public Cliente() {
    }

    public Cliente(String email, String nombre, String domicilio, String nif, int cuota, int descuento) {
        this.email = email;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.cuota = cuota;
        this.descuento = descuento;
    }

    public Cliente(String nombre, String domicilio, String nif, int cuota, int descuento) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.cuota = cuota;
        this.descuento = descuento;
    }

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
    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    @Basic
    @Column(name = "descuento")
    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
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
        if (cuota != cliente.cuota) return false;
        if (descuento != cliente.descuento) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + cuota;
        result = 31 * result + descuento;
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
