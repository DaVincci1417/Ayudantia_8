package Controller;

import Model.Articulo;
import Model.Cliente;
import Model.Data.DAO.ArticuloDAO;
import Model.Data.DAO.ClienteDAO;
import Model.Data.DBGenerator;
import com.mysql.cj.xdevapi.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "agregarArticuloServlet", value = "/agregarArticulo")
public class agregarArticuloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("TiendaElectronica");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarArticulo.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/camposVaciosAgregarArticulo.jsp");
        if(req.getParameter("nombreArticulo").length() !=0 && req.getParameter("tipo").length() != 0 &&
                req.getParameter("peso").length() != 0 && req.getParameter("precio").length() != 0) {
            String nombre = req.getParameter("nombreArticulo");
            int peso = Integer.parseInt(req.getParameter("peso"));
            String tipo = req.getParameter("tipo");
            int precio = Integer.parseInt(req.getParameter("precio"));


            Articulo articulo = new Articulo(nombre, tipo, peso, precio);

            try {
                if(agregarArticulo(articulo)){
                    req.setAttribute("Articulo",articulo);
                    respuesta = req.getRequestDispatcher("/exitoAgregarArticulo.jsp");
                }else{
                    respuesta = req.getRequestDispatcher("/errorAgregarArticuloRepetido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarArticulo(Articulo articulo) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("TiendaElectronica");
        List<Model.Articulo> articulos = ArticuloDAO.obtenerArticulo(query,"nombre_articulo", articulo.getNombreArticulo());
        if(articulos.size() != 0){
            return false;
        }
        else{
            ArticuloDAO.agregarArticulo(query,articulo);
            return true;
        }
    }
}
