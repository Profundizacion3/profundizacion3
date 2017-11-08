package profundizacion.software.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import profundizacion.software.model.Pregunta;

public class PreguntaMapper implements RowMapper<Pregunta> {
	
	public Pregunta mapRow(ResultSet rs, int rowNum) throws SQLException{
		Pregunta pregunta = new Pregunta();
		
		pregunta.setCodigo(rs.getInt("pre_codigo"));
		pregunta.setEnunciado(rs.getString("pre_enunciado"));
		pregunta.setOpcion1(rs.getString("pre_opcion1"));
		pregunta.setOpcion2(rs.getString("pre_opcion2"));
		pregunta.setOpcion3(rs.getString("pre_opcion3"));
		pregunta.setOpcion4(rs.getString("pre_opcion4"));
		pregunta.setOpcion5(rs.getString("pre_opcion5"));
		pregunta.setRespuesta(rs.getString("pre_respuesta"));
		pregunta.setCodAreaConocimiento(rs.getInt("pre_codareaconocimiento"));
		
		return pregunta;
	}

}
