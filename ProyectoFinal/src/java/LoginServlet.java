
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginServlet extends HttpServlet {

    // ... (código omitido para brevedad)

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Coneccion base = new Coneccion();
            ResultSet rs = base.consultaSQL("select * from usuario where email ="
                    + "'" +  request.getParameter("inputEmail") +  "'" + " and contraseña = "
                    + "'" +  request.getParameter("inputPassword") +  "'" );
           if (rs.next()) {
    // Usuario y contraseña correctos
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Resultado de la búsqueda</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2> Bienvenido a Nuestro Sistema</h2>" + "<BR>");
    out.println(rs.getString("nombre_usuario") + "<BR> "
            +"<h3> su email es: </h3>"    + "<br>");
    out.println(rs.getString("email") + "<BR>");
    out.println("</body>");
    out.println("</html>");
} else {
    // Usuario o contraseña incorrectos
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Resultado de la búsqueda</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("No hay usuarios que coincidan con la búsqueda");
    out.println("<h1>Proyecto:  " + request.getContextPath() + "</h1>");
    out.println("<h1>Usuario es:  " + request.getParameter("inputEmail") + "</h1>");
    out.println("</body>");
    out.println("</html>");
        }
            
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

 

 
 