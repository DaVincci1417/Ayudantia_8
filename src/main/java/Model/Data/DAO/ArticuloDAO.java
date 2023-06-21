package Model.Data.DAO;

import Model.Articulo;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ArticuloDAO {
    public static void agregarArticulo(DSLContext query, Articulo articulo){
        Table tablaArticulo = table(name("Articulo"));
        Field[] columnas = tablaArticulo.fields("nombre_articulo","tipo_articulo","peso","precio");
        query.insertInto(tablaArticulo, columnas[0], columnas[1], columnas[2], columnas[3])
                .values(articulo.getNombreArticulo(), articulo.getTipoArticulo(), articulo.getPeso(), articulo.getPrecio())
                .execute();
    }
    public static void modificarArticulo(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(DSL.table("Articulo")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("nombre_articulo").eq(nombre)).execute();
    }
    public static List obtenerArticulo(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(DSL.table("Articulo")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaArticulos(resultados);
    }
    public static List obtenerArticulos(DSLContext query){
        Result resultados = query.select().from(DSL.table("Articulo")).fetch();
        return obtenerListaArticulos(resultados);
    }
    public static void eliminarArticulo(DSLContext query, String nombre){
        Table tablaLibro = table(name("Articulo"));
        query.delete(DSL.table("Articulo")).where(DSL.field("nombre_articulo").eq(nombre)).execute();
    }
    private static List obtenerListaArticulos(Result resultados){
        List<Articulo> articulos = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String nombre = (String) resultados.getValue(fila,"nombre_articulo");
            String tipoArticulo = (String) resultados.getValue(fila,"tipo_articulo");
            int peso = (Integer) resultados.getValue(fila,"peso");
            int precio = (Integer) resultados.getValue(fila,"precio");

            articulos.add(new Articulo(nombre, tipoArticulo, peso, precio));
        }
        return articulos;
    }
}
