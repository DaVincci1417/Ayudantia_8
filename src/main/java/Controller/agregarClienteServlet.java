package Controller;

import Model.Cliente;
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

@WebServlet(name = "agregarClienteServlet", value = "/agregarCliente")
public class agregarClienteServlet extends HttpServlet {
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
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarCliente.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/camposVaciosAgregarCliente.jsp");
        if(req.getParameter("nombreCliente").length() != 0 && req.getParameter("rut").length() != 0 && req.getParameter("correo").length() != 0){
            String nombre = req.getParameter("nombreCliente");
            int rut = Integer.parseInt(req.getParameter("rut"));
            String correo = req.getParameter("correo");

            Cliente cliente = new Cliente(nombre, rut, correo);

            try {
                if(agregarCliente(cliente)){
                    req.setAttribute("Cliente",cliente);
                    respuesta = req.getRequestDispatcher("/exitoAgregarCliente.jsp");
                }else{
                    respuesta = req.getRequestDispatcher("/errorAgregarClienteRepetido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarCliente(Cliente cliente) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("TiendaElectronica");
        List<Cliente> clientes = ClienteDAO.obtenerCliente(query,"rut", cliente.getRut());
        if(clientes.size() != 0){
            return false;
        }
        else{
            ClienteDAO.agregarCliente(query,cliente);
            return true;
        }
    }
}
