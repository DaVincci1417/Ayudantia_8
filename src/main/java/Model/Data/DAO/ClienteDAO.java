package Model.Data.DAO;

import Model.Articulo;
import Model.Cliente;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ClienteDAO{
    public static void agregarCliente(DSLContext query, Cliente cliente){
        Table tablaCliente = table(name("Cliente"));
        Field[] columnas = tablaCliente.fields("rut","nombre_cliente","correo_electronico");
        query.insertInto(tablaCliente, columnas[0], columnas[1], columnas[2])
                .values(cliente.getRut(), cliente.getNombreCliente(), cliente.getCorreo())
                .execute();
    }
    public static void modificarCliente(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(DSL.table("Cliente")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("rut").eq(nombre)).execute();
    }
    public static List obtenerCliente(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Cliente")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaClientes(resultados);
    }
    public static List obtenerClientes(DSLContext query){
        Result resultados = query.select().from(DSL.table("Cliente")).fetch();
        return obtenerListaClientes(resultados);
    }
    public static void eliminarArticulo(DSLContext query, String nombre){
        Table tablaLibro = table(name("Cliente"));
        query.delete(DSL.table("Cliente")).where(DSL.field("rut").eq(nombre)).execute();
    }
    private static List obtenerListaClientes(Result resultados){
        List<Cliente> clientes = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String nombreCliente = (String) resultados.getValue(fila,"nombre_cliente");
            int rut = (Integer) resultados.getValue(fila,"rut");
            String correo = (String) resultados.getValue(fila,"correo_electronico");

            clientes.add(new Cliente(nombreCliente,  rut, correo));
        }
        return clientes;
    }
}
