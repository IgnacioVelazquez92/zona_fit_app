package zona_fit.datos;

import zona_fit.connection.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        PreparedStatement ps;
        ResultSet rs;
        Connection conexion = Conexion.getConexion();
        var sql = "SELECT * FROM cliente ORDER BY idcliente";
        try{
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var cliente = new Cliente();
                rs.getInt("idcliente");
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
        }
        catch (Exception e) {
            System.out.println("error = " + e);
            e.printStackTrace();
        }finally {
            try {
                conexion.close();
            }catch (Exception e) {
                System.out.println("error = " + e);
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection conexion = Conexion.getConexion();
        var sql = "SELECT * FROM cliente WHERE idcliente = ?";
        try{
            ps=conexion.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs=ps.executeQuery();
            if(rs.next()){
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }
        }
        catch (Exception e) {
            System.out.println("error al buscar el id = " + e);
        }
        finally {
            try {
                conexion.close();
            }catch (Exception e) {
                System.out.println("error = " + e);
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection conexion = getConexion;
        String sql = "INSERT INTO cliente(nonbre, apellido, membresia) VALUES(?,?,?)"
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("...:::LISTAR CLIENTES:::...");
        IClienteDAO clienteDAO = new ClienteDAO();
        var clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        //bucar por ID
        var cliente = new Cliente(1);
        System.out.println("cliente = " + cliente);
        var encontrado = clienteDAO.buscarClientePorId(cliente);
        if (encontrado) {
            System.out.println("cliente encontrado");
            System.out.println("cliente = "+ cliente.getNombre() + " " + cliente.getApellido() );
        }else {
            System.out.println("cliente no encontrado");
        }

    }
}
