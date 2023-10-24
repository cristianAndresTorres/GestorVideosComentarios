package com.example.demo.models.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.demo.models.Comentario;

public class ComentarioDAO {
	//Atributos
	private int estado;
	protected Connection miConexion;
    protected PreparedStatement consultaRegristro;
    protected ResultSet r;    
    protected Connection conexionBD = null;
    private static ComentarioDAO comentarioDAO = new ComentarioDAO();
    private ArrayList<Comentario> listaComentarios = new ArrayList<>();
    private Comentario comentario;
		
    private ComentarioDAO() {	
    }
    
    //Permite obtener un listado de videotutoriales
    public ArrayList<Comentario> obtenerListaComentarios(Integer idVideoTutorial){   
        listaComentarios.removeAll(listaComentarios);
        try {
           String sql = "Select * from Comentario where fk_idVideoTutorial = ? ";
           //------------------------------------------------------------------
           miConexion = ConexionBD.getMiconexionBD().realizarConexionBD();
           consultaRegristro = miConexion.prepareStatement(sql);
           //------------------------------------------------------------------
            
           consultaRegristro.setInt(1, idVideoTutorial);
      
           r = consultaRegristro.executeQuery();
           //---------------------------------------------------------------------
           while(r.next()){
        	   comentario = new Comentario();
        	   comentario.setIdcomentario(r.getInt(1));
        	   comentario.setDescripcion(r.getString(2));
        	   comentario.setFecha(r.getString(3));
        	   comentario.setAutor(r.getString(4));
        	   comentario.setFk_idvideotutorial(r.getInt(5)); 
               System.out.println("Obteniendo comentario...");
               listaComentarios.add(comentario);
           }
        System.out.println(estado);
        r.close();
        miConexion.close();
        } catch (Exception e) {
            System.err.println("Error obtenerListaComentarios");
        }        
        return listaComentarios;
    }
    
    //Permite guardar un comentario asociado a un videotutorial	
	public int guardarComentario(Comentario comentario){
    	try {
            //1-> realizar conexion
    		miConexion = ConexionBD.getMiconexionBD().realizarConexionBD();
            //2-> Preparar Consulta-preParada
            
            String sqlResgistro = "Insert into Comentario(descripcion,fecha,"
            		+ "autor,fk_idVideoTutorial)"+
            " values(?,?,?,?)";
            consultaRegristro = miConexion.prepareStatement(sqlResgistro);
            //3-> Pasar parametros de la consulta
            consultaRegristro.setString(1, comentario.getDescripcion());
            consultaRegristro.setString(2, comentario.getFecha());
            consultaRegristro.setString(3, comentario.getAutor());
            consultaRegristro.setInt(4, comentario.getFk_idvideotutorial());
            //4-> realizar modificacion
            consultaRegristro.execute();
            miConexion.close();
            System.out.println("Exitos!!!-guardarComentario");
            estado = 1;
        } catch (Exception e) {
            System.out.println("Error-guardarComentario");
            estado = 0;
        }
        return estado;
	}

	public static ComentarioDAO getComentarioDAO() {
		return comentarioDAO;
	}
	
	
}
