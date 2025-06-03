import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioDAO {
    private final Coneccion conexion;
    
    public UsuarioDAO() {
        conexion = new Coneccion();
    }
    
    public ResultSet validarUsuario(String email, String password){
        String sql = "SELECT * FROM usuario WHERE email = ? AND contraseña = ?";
        String hashed = hashPassword(password);
        return conexion.consultaSQL(sql, email, hashed);
    }
    
    public void cerrar(){
        conexion.cerrar();
    }

    private String hashPassword(String pwd){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pwd.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b : hash){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Si no se puede hashear, se devuelve la contraseña sin procesar
            return pwd;
        }
    }
}
