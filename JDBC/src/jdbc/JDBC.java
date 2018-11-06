package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class JDBC {

    public static void main(String[] args) {
      String conexao = "valor";
        try{
            Connection mysql = DriverManager.getConnection(
                   "jdbc:mysql://localhost/agenda",
                   "root",
                   "1q"
            );
            String sql = "delete from contatos where id = 2";
            PreparedStatement instrucao = mysql.prepareStatement(sql);
            
                        
            instrucao.execute();
            
            System.out.println("Conectado!");
        } catch (SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e.getMessage());
        }
     }
    
}
