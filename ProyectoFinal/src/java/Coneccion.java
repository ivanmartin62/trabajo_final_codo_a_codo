
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ivanmartin
 */
public class Coneccion {
	private Connection cn;
    private ResultSet  rs;
    private PreparedStatement ps;
    
    
    
    public  String servidor,basededatos, usuario, clave, ejecutar;
    
    
    public Connection conectarse(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
       
        
        servidor= "localhost:3306/";
        basededatos= "trabajo_final";
        usuario= "root";
        clave="123456";
        
        
        
        cn=DriverManager.getConnection("jdbc:mysql://" + servidor 
        +  basededatos+"?autoReconnect=true&useSSL=false", usuario, clave);
        
         } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return cn;
    }
    
    //*************************************************************************************
    
    
    public ResultSet consultaSQL(String busqueda){

        try {
            ps= conectarse().prepareStatement(busqueda);
        rs=ps.executeQuery();


         } catch (SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet consultaSQL(String busqueda, String... params){
        try {
            ps = conectarse().prepareStatement(busqueda);
            for(int i=0; i<params.length; i++){
                ps.setString(i+1, params[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void cerrar(){
        try {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(cn != null) cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}

