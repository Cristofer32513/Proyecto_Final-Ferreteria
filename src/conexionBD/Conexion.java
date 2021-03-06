package conexionBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Prod;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Usuario;
import modelo.Venta;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Conexion {
    public static Connection conexion;
    private PreparedStatement pstm;
    private final static String DRIVER="org.postgresql.Driver";
    private final static String URL="jdbc:postgresql://localhost:5432/Ferreteria";
    ResultSet rs=null;
    private static Conexion conexionB;
    Statement stm;
    
    public static Conexion getConexion() {
        if (conexionB==null)
            conexionB=new Conexion();
        
        return conexionB;
    }
    
    private Conexion(){
        abrirConexion();
    }
    
    public final void abrirConexion() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, "Cristofer", "casas");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el controlador.\n" + e.getMessage(), "Error de conexion", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conctar al servidor.\n" + e.getMessage(), "Error de conexion", JOptionPane.ERROR_MESSAGE);
        } finally {}
    }
    
    public void cerrarConexion(){
        try {
            pstm.close();
            conexion.close();
        } catch(SQLException e){}
    } 
    
    public boolean ejecutarAlta(String sql, Usuario usuario) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setInt(1, usuario.getIdEmpleado());
            pstm.setString(2, usuario.getUsuario());
            pstm.setString(3, usuario.getContraseña());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public boolean ejecutarBaja(String sql, int id) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setInt(1, id);
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
	
    public boolean ejecutarModificacion(String sql, Usuario usuario) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, usuario.getUsuario());
            pstm.setString(2, usuario.getContraseña());
            pstm.setInt(3, usuario.getIdEmpleado());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public ResultSet ejecutarConsultaUsuarios(String sql, String usuario, String contraseña) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, usuario);
            pstm.setString(2, contraseña);
            rs=pstm.executeQuery();
        } catch(SQLException e) {}
        
        return rs;
    }
    
    public ResultSet ejecutarConsultaUsuarios(String sql, int idEmpleado) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setInt(1, idEmpleado);
            rs=pstm.executeQuery();
        } catch(SQLException e) {}
       
        return rs;
    }
    
    public boolean ejecutarAlta(String sql, Categoria categoria) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, categoria.getNombre());
            pstm.setString(2, categoria.getDescripcion());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
	
    public boolean ejecutarModificacion(String sql, Categoria categoria) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, categoria.getNombre());
            pstm.setString(2, categoria.getDescripcion());
            pstm.setInt(3, categoria.getIdCategoria());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public ResultSet ejecutarConsultaID(String sql, int id) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setInt(1, id);
            rs=pstm.executeQuery();
        } catch(SQLException e) {}
        
        return rs;
    }
    
    public boolean ejecutarAlta(String sql, Cliente cliente) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getPrimerApellido());
            pstm.setString(3, cliente.getSegundoApellido());
            pstm.setString(4, cliente.getTelefono());
            pstm.setString(5, cliente.getCalle());
            pstm.setString(6, cliente.getColonia());
            pstm.setString(7, cliente.getMunicipio());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public boolean ejecutarModificacion(String sql, Cliente cliente) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getPrimerApellido());
            pstm.setString(3, cliente.getSegundoApellido());
            pstm.setString(4, cliente.getTelefono());
            pstm.setString(5, cliente.getCalle());
            pstm.setString(6, cliente.getColonia());
            pstm.setString(7, cliente.getMunicipio());
            pstm.setInt(8, cliente.getIdCliente());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public boolean ejecutarAlta(String sql, Empleado empleado) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, empleado.getNombre());
            pstm.setString(2, empleado.getPrimerApellido());
            pstm.setString(3, empleado.getSegundoApellido());
            pstm.setString(4, empleado.getCargo());
            pstm.setString(5, empleado.getCalle());
            pstm.setString(6, empleado.getColonia());
            pstm.setString(7, empleado.getMunicipio());
            pstm.setString(8, empleado.getTelefono());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public boolean ejecutarModificacion(String sql, Empleado empleado) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, empleado.getNombre());
            pstm.setString(2, empleado.getPrimerApellido());
            pstm.setString(3, empleado.getSegundoApellido());
            pstm.setString(4, empleado.getCargo());
            pstm.setString(5, empleado.getCalle());
            pstm.setString(6, empleado.getColonia());
            pstm.setString(7, empleado.getMunicipio());
            pstm.setString(8, empleado.getTelefono());
            pstm.setInt(9, empleado.getIdEmpleado());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public ResultSet ejecutarConsultaID(String sql, String nombre, String primerAp, String segundoAp, String cargo, String calle, String colonia, String municipio, String telefono) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, nombre);
            pstm.setString(2, primerAp);
            pstm.setString(3, segundoAp);
            pstm.setString(4, cargo);
            pstm.setString(5, calle);
            pstm.setString(6, colonia);
            pstm.setString(7, municipio);
            pstm.setString(8, telefono);
            rs=pstm.executeQuery();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo ejecutar la consulta SQL" + e.getMessage(), "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        return rs;
    }
    
    public boolean ejecutarAlta(String sql, Proveedor proveedor) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, proveedor.getNombre());
            pstm.setString(2, proveedor.getPrimerApellido());
            pstm.setString(3, proveedor.getSegundoApellido());
            pstm.setString(4, proveedor.getTelefono());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
	
    public boolean ejecutarModificacion(String sql, Proveedor proveedor) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, proveedor.getNombre());
            pstm.setString(2, proveedor.getPrimerApellido());
            pstm.setString(3, proveedor.getSegundoApellido());
            pstm.setString(4, proveedor.getTelefono());
            pstm.setInt(5, proveedor.getIdProveedor());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public boolean ejecutarAlta(String sql, Producto producto) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, producto.getNombre());
            pstm.setString(2, producto.getMarca());
            pstm.setDouble(3, producto.getPrecio());
            pstm.setInt(4, producto.getStock());
            pstm.setInt(5, producto.getIdProveedor());
            pstm.setInt(6, producto.getIdCategoria());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
      
    public boolean ejecutarModificacion(String sql, Producto producto) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, producto.getNombre());
            pstm.setString(2, producto.getMarca());
            pstm.setDouble(3, producto.getPrecio());
            pstm.setInt(4, producto.getStock());
            pstm.setInt(5, producto.getIdProveedor());
            pstm.setInt(6, producto.getIdCategoria());
            pstm.setInt(7, producto.getIdProducto());
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public boolean ejecutarAlta(String sql, Venta venta) throws ParseException {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            conexion.setAutoCommit(false);
            pstm.setInt(1, venta.getIdEmpleado());
            pstm.setInt(2, venta.getIdCliente());
            pstm.setString(3, venta.getNombreCliente());
            pstm.setInt(4, venta.getIdProducto());
            pstm.setString(5, venta.getNombreProducto());
            pstm.setInt(6, venta.getCantidad());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(venta.getFecha());
            Date aba = new java.sql.Date(parsed.getTime());
            pstm.setDate(7, aba);

            
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            conexion.commit();
            return ejecucion==1;
        } catch(SQLException e){
            try {
                conexion.rollback();
                conexion.setAutoCommit(true);
            } catch (SQLException ex) {}
            return false;
        }
    }
    
    public boolean ejecutarAlta(String sql, int campo1) {
        try {
            pstm=conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setInt(1, campo1);
                        
            int ejecucion;
            ejecucion=pstm.executeUpdate();
            
            return ejecucion==1;
        } catch(SQLException e){return false;}
    }
    
    public void totalStock() {
        String sql = "SELECT Nombre, Stock FROM Productos ORDER BY Stock;";
        ResultSet resset;
        Prod prod = new Prod();
        
        JFreeChart grafica;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        try {
            stm = conexion.createStatement(); 
            resset = stm.executeQuery(sql);
            
            while(resset.next()){
                prod.setNombre(resset.getString(1));
                prod.setStock(resset.getInt(2));
                
                dataSet.addValue(prod.getStock(), "Stock", prod.getNombre());                
            }
            
            grafica = ChartFactory.createBarChart("Stock", "Productos", "Stock de Productos", dataSet, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel panel = new ChartPanel(grafica);
            JFrame info = new JFrame("Grafica de Stock");
            info.getContentPane().add(panel);
            info.pack();
            info.setLocationRelativeTo(null);
            info.setVisible(true);              
        } catch (SQLException e) {}
    }
    
    public void ventasPorEmpleado() {
        String sql = "SELECT id_Empleado, COUNT(id_Empleado) AS ventas_e FROM ventas group by id_Empleado order by ventas_e;";
        ResultSet resset;
        Prod prod = new Prod();
        
        JFreeChart grafica;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        try {
            stm = conexion.createStatement(); 
            resset = stm.executeQuery(sql);
            
            while(resset.next()){
                prod.setNombre(resset.getString(1));
                prod.setStock(resset.getInt(2));
                
                dataSet.addValue(prod.getStock(), "Ventas realizadas", prod.getNombre());                
            }
            
            grafica = ChartFactory.createBarChart("Status de ventas", "Id de empleado", "Cantidad de ventas", dataSet, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel panel = new ChartPanel(grafica);
            JFrame info = new JFrame("Grafica de ventas por usuario");
            info.getContentPane().add(panel);
            info.pack();
            info.setLocationRelativeTo(null);
            info.setVisible(true);         
        } catch (SQLException e) {}
    }
    
    public void comprasPorCliente() {
        String sql = "SELECT id_Cliente, COUNT(id_Cliente) AS compras FROM ventas group by id_Cliente order by compras;";
        ResultSet resset;
        Prod prod = new Prod();
        
        JFreeChart grafica;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        try {
            stm = conexion.createStatement(); 
            resset = stm.executeQuery(sql);
            
            while(resset.next()){
                prod.setNombre(resset.getString(1));
                prod.setStock(resset.getInt(2));
                
                dataSet.addValue(prod.getStock(), "Compras realizadas", prod.getNombre());                
            }
            
            grafica = ChartFactory.createBarChart("Status de ventas", "Id de cliente", "Cantidad de compras", dataSet, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel panel = new ChartPanel(grafica);
            JFrame info = new JFrame("Grafica de compras por cliente");
            info.getContentPane().add(panel);
            info.pack();
            info.setLocationRelativeTo(null);
            info.setVisible(true);        
        } catch (SQLException e) {}
    }
}