package Controller;

import Model.Articulo;
import Model.Cliente;
import Model.Data.DAO.ArticuloDAO;
import Model.Data.DAO.ClienteDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "buscarArticuloNombreServlet", value = "/buscarArticuloNombre")
public class buscarArticuloNombreServlet extends HttpServlet {
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
        RequestDispatcher respuesta = request.getRequestDispatcher("/buscarArticuloPorNombre.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/camposVaciosBuscarPorNombre.jsp");
        if(req.getParameter("nombreArticulo").length() !=0) {
            String nombreArticulo = req.getParameter("nombreArticulo");

            try {
                if(obtenerArticulo(nombreArticulo)){
                    req.setAttribute("Articulo", nombreArticulo);
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
    private boolean obtenerArticulo(String nombreArticulo) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("TiendaElectronica");
        List<Articulo> articulos = ArticuloDAO.obtenerArticulo(query,"nombre_articulo", nombreArticulo);
        if(articulos.size() != 0){
            return false;
        }
        else{
            return true;
        }
    }
}
