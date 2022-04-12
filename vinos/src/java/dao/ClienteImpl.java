package dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cliente;

/* codcli || nomcli ||apepatcli || apematcli || dnicli || emailcli 
celcli || dircli ||estcli ||fecnaccli*/
public class ClienteImpl extends Conexion implements ICRUD<Cliente> {

    @Override
    public void registrar(Cliente cliente) throws Exception {
        try {
            String sql = "INSERT INTO CLIENTE" + "(CODCLI,NOMCLI,APEPACLI,APEMATCLI,DNICLI,EMAILCLI,CELCLI,DIRCLI,ESTCLI,FECNACCLI)"
                    + "?,?,?,?,?,?,?,?,?,?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, cliente.getCodcli());
            ps.setString(2, cliente.getNomcli());
            ps.setString(3, cliente.getApepatcli());
            ps.setString(4, cliente.getApematcli());
            ps.setString(5, cliente.getDnicli());
            ps.setString(6, cliente.getEmailcli());
            ps.setString(7, cliente.getCelcli());
            ps.setString(8, cliente.getDircli());
            ps.setString(9, cliente.getEstcli());
            ps.setString(10, cliente.getFecnaccli());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error en ClienteImpl/Registrar" + e.getMessage());
        }
    }

    @Override
    public void modificar(Cliente cliente) throws Exception {
        try {
            String sql = "update paciente set CODCLI,NOMCLI,APEPACLI,APEMATCLI,DNICLI,EMAILCLI,CELCLI,DIRCLI,ESTCLI,FECNACCLI where DNICLI=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, cliente.getCodcli());
            ps.setString(2, cliente.getNomcli());
            ps.setString(3, cliente.getApepatcli());
            ps.setString(4, cliente.getApematcli());
            ps.setString(5, cliente.getDnicli());
            ps.setString(6, cliente.getEmailcli());
            ps.setString(7, cliente.getCelcli());
            ps.setString(8, cliente.getDircli());
            ps.setString(9, cliente.getEstcli());
            ps.setString(10, cliente.getFecnaccli());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en ClienteImpl/Modificar" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Cliente cliente) throws Exception {
        try {
            String sql = "DELETE CLIENTE WHERE DNICLI=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getDnicli());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en ClienteImpl/Eliminar" + e.getMessage());
        }
    }

    @Override
    public List<Cliente> listarTodos() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM CLIENTE";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodcli(rs.getInt("CODCLI"));
                cliente.setNomcli(rs.getString("NOMCLI"));
                cliente.setApepatcli(rs.getString("APEPACLI"));
                cliente.setApematcli(rs.getString("APEMATCLI"));
                cliente.setDnicli(rs.getString("DNICLI"));
                cliente.setEmailcli(rs.getString("EMAILCLI"));
                cliente.setCelcli(rs.getString("CELCLI"));
                cliente.setDircli(rs.getString("DIRCLI"));
                cliente.setEstcli(rs.getString("ESTCLI"));
                cliente.setFecnaccli(rs.getString("FECNACCLI"));
                lista.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error en CliemteImpl/Listar" + e.getMessage());
        }
        return lista;
    }
}
