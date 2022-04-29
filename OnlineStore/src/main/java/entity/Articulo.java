package entity;

import javax.persistence.*;

@Entity
@Table(name = "articulos", schema = "fp_206_java_con_mysql", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
})
public class Articulo {
    private String codigo;
    private String descripcion;
    private Double pvp;
    private Double gastosEnvio;
    private int tiempoPreparacion;

    public Articulo() {
    }

    public Articulo(String codigo) {
        this.codigo = codigo;
    }

    public Articulo(String codigo, String descripcion, Double pvp, Double gastosEnvio, int tiempoPreparacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.gastosEnvio = gastosEnvio;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Id
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "pvp")
    public Double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    @Basic
    @Column(name = "gastos_envio")
    public Double getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    @Basic
    @Column(name = "tiempo_preparacion")
    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Articulo articulo = (Articulo) o;

        if (tiempoPreparacion != articulo.tiempoPreparacion) return false;
        if (codigo != null ? !codigo.equals(articulo.codigo) : articulo.codigo != null) return false;
        if (descripcion != null ? !descripcion.equals(articulo.descripcion) : articulo.descripcion != null)
            return false;
        if (pvp != null ? !pvp.equals(articulo.pvp) : articulo.pvp != null) return false;
        if (gastosEnvio != null ? !gastosEnvio.equals(articulo.gastosEnvio) : articulo.gastosEnvio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (pvp != null ? pvp.hashCode() : 0);
        result = 31 * result + (gastosEnvio != null ? gastosEnvio.hashCode() : 0);
        result = 31 * result + tiempoPreparacion;
        return result;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", pvp=" + pvp +
                ", gastosEnvio=" + gastosEnvio +
                ", tiempoPreparacion=" + tiempoPreparacion +
                '}';
    }
}
