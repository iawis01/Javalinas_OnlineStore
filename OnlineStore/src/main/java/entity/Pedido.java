package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pedidos", schema = "fp_206_java_con_mysql", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
        @NamedQuery(name = "Pedido.findAllPendiente", query = "SELECT p FROM Pedido p WHERE p.procesado = false"),
        @NamedQuery(name = "Pedido.findAllEnviado", query = "SELECT p FROM Pedido p WHERE p.procesado = true")
})
public class Pedido {
    private int numeroPedido;

    private Cliente clientesByEmailCliente;
    private Articulo articulosByCodigoArticulo;
    private int cantidad;
    private Timestamp fecha;
    private boolean procesado;


    public Pedido() {
    }

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Pedido(int numeroPedido, Cliente clientesByEmailCliente, Articulo articulosByCodigoArticulo, int cantidad, Timestamp fecha, boolean procesado) {
        this.numeroPedido = numeroPedido;
        this.clientesByEmailCliente = clientesByEmailCliente;
        this.articulosByCodigoArticulo = articulosByCodigoArticulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.procesado = procesado;
    }

    public Pedido(Cliente clientesByEmailCliente, Articulo articulosByCodigoArticulo, int cantidad, Timestamp fecha, boolean procesado) {
        this.clientesByEmailCliente = clientesByEmailCliente;
        this.articulosByCodigoArticulo = articulosByCodigoArticulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.procesado = procesado;
    }

    @Id
    @Column(name = "numero_pedido")
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    @Basic
    @Column(name = "cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "procesado")
    public boolean getProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        if (numeroPedido != pedido.numeroPedido) return false;
        if (cantidad != pedido.cantidad) return false;
        if (procesado != pedido.procesado) return false;
        if (fecha != null ? !fecha.equals(pedido.fecha) : pedido.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numeroPedido;
        result = 31 * result + cantidad;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "email_cliente", referencedColumnName = "email", nullable = false)
    public Cliente getClientesByEmailCliente() {
        return clientesByEmailCliente;
    }

    public void setClientesByEmailCliente(Cliente clientesByEmailCliente) {
        this.clientesByEmailCliente = clientesByEmailCliente;
    }

    @ManyToOne
    @JoinColumn(name = "codigo_articulo", referencedColumnName = "codigo", nullable = false)
    public Articulo getArticulosByCodigoArticulo() {
        return articulosByCodigoArticulo;
    }

    public void setArticulosByCodigoArticulo(Articulo articulosByCodigoArticulo) {
        this.articulosByCodigoArticulo = articulosByCodigoArticulo;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + numeroPedido +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                ", procesado=" + procesado +
                ", clientesByEmailCliente=" + clientesByEmailCliente +
                ", articulosByCodigoArticulo=" + articulosByCodigoArticulo +
                '}';
    }
}
