import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thayse
 */
@WebServlet(name = "CriarContatos", urlPatterns = {"/CriarContatos"})
public class CriarContatos extends HttpServlet {
    private String nome = null;
    private String endereco = null;
    private String email = null;
    private String data = null;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        nome = request.getParameter("nome");
        endereco = request.getParameter("endereco");
        email = request.getParameter("email");
        response.setContentType("text/html;charset=UTF-8");
       
        try {
            Connection mysql = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/agenda", "root","091911");
            String sql = "insert into contato" + "(nome, endereco, data_nasc, email)" + 
                    "values(?, ?, ?, ?)";
            PreparedStatement instrucao = mysql.prepareStatement (sql);
            instrucao.setString(1, nome);
            instrucao.setString(2, endereco);
            instrucao.setString(3, data);
            instrucao.setString(4, email);
            instrucao.execute();
        }
        
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}