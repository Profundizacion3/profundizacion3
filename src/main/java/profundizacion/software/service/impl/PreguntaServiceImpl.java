package profundizacion.software.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import profundizacion.software.model.Pregunta;
import profundizacion.software.service.PreguntaService;
import profundizacion.software.service.mapper.PreguntaMapper;



@Service("preguntaService")
public class PreguntaServiceImpl implements PreguntaService {
	
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	 private final String INSERT_SQL = "INSERT INTO pregunta("
			 											+ "pre_enunciado,"
			 											+ "pre_opcion1,"
			 											+ "pre_opcion2,"
			 											+ "pre_opcion3,"
			 											+ "pre_opcion4,"
			 											+ "pre_opcion5," 
			 											+ "pre_respuesta,"
			 											+ " pre_codareaconocimiento)"
			 									+ "VALUES ( ?, ?, ?, ?,?, ?, ?, ?); ";
	 
	 private final String UPDATE_SLQ = "UPDATE pregunta SET  "
	 											+ "pre_enunciado=?, "
	 											+ "pre_opcion1=?, "	
	 											+ "pre_opcion2=?, "
	 											+ "re_opcion3=?, "
	 											+ "pre_opcion4=?, "
	 											+ "pre_opcion5=?," 
	 											+ "pre_respuesta=?, "
	 											+ "pre_codareaconocimiento=? "
	 										+ "WHERE pre_codigo=?; ";
	 
	 private final String DELETE_SQL = "DELETE FROM pregunta WHERE pre_codigo = ?";
	 
	 private final String FETCH_SQL  = "SELECT * FROM pregunta ;";
	 
	 private final String FETCH_SQL_BY_COD_AREA = "SELECT * FROM pregunta WHERE pre_codareaconocimiento = ?;";
	 
	 private final String FETCH_SQL_BY_ID = "SELECT * FROM pregunta WHERE pre_codigo = ?";
	 
	
	@Override
	public List<Pregunta> findPreguntasByCodAreaConocimiento(long codAreaConocimiento) {
			
		//return jdbcTemplate.execute(FETCH_SQL_BY_COD_AREA);
		
			return jdbcTemplate.query(
							FETCH_SQL_BY_COD_AREA,
							new PreguntaMapper(),
							codAreaConocimiento 
							);
		}

	@Override
	public Pregunta findById(long codigo) {
		
		return (Pregunta) jdbcTemplate.queryForObject(
											FETCH_SQL_BY_ID, 
											new Object [] {codigo}, 
											new PreguntaMapper());
	}

	@Override
	public Pregunta findByEnunciado(String enuncuiado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta createPregunta(final Pregunta pregunta) {
		
		KeyHolder holder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator (){

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, pregunta.getEnunciado());
				ps.setString(2, pregunta.getOpcion1());
				ps.setString(3, pregunta.getOpcion2());
				ps.setString(4, pregunta.getOpcion3());
				ps.setString(5, pregunta.getOpcion4());
				ps.setString(6, pregunta.getOpcion5());
				ps.setString(7, pregunta.getRespuesta());
				ps.setInt(8, pregunta.getCodAreaConocimiento());
				return ps;
			}
			
		}, holder);
		
		int newPreguntaCodigo = holder.getKey().intValue();
		System.out.println("new pregunta created: "+ newPreguntaCodigo);
		pregunta.setCodigo(newPreguntaCodigo);
		
		return pregunta;
	}

	@Override
	public Pregunta updatePregunta(Pregunta pregunta) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SLQ);
				
				ps.setString(1, pregunta.getEnunciado());
				ps.setString(2, pregunta.getOpcion1());
				ps.setString(3, pregunta.getOpcion2());
				ps.setString(4, pregunta.getOpcion3());
				ps.setString(5, pregunta.getOpcion4());
				ps.setString(6, pregunta.getOpcion5());
				ps.setString(7, pregunta.getRespuesta());
				ps.setInt(8, pregunta.getCodAreaConocimiento());
				ps.setLong(9, pregunta.getCodigo());
				
				return ps;
			}
		});
		return pregunta;
	}

	@Override
	public void deletePreguntaById(long codigo) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(DELETE_SQL);
				
				ps.setLong(1, codigo);
				return ps;
				
			}
		});
	}

	@Override
	public List<Pregunta> findAllPreguntas() {
		
		return jdbcTemplate.query(FETCH_SQL, new PreguntaMapper());
	}

	@Override
	public boolean ifPregunaExist(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return false;
	}

	

}


