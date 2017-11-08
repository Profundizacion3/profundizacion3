package profundizacion.software.service.impl;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;


import profundizacion.software.model.AreaConocimiento;
import profundizacion.software.service.AreaConocimientoService;
import profundizacion.software.service.mapper.AreaConocimientoMapper;


@Service("areaConocimientoService")
public class AreaConocimientoServiceImpl implements AreaConocimientoService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	 private final String INSERT_SQL = " INSERT INTO area_conocimiento("
			 										+ " aco_nombre, "
			 										+ "aco_descripcion)"
			 									    + " VALUES ( ?, ?);";

	 private final String UPDATE_SLQ = "UPDATE area_conocimiento"
			 								+ " SET  aco_nombre=?, "
			 								+ " aco_descripcion=?"
			 								+ " WHERE aco_codigo=?;";

	 private final String DELETE_SQL = "DELETE FROM area_conocimiento WHERE aco_codigo = ?";

	 private final String FETCH_SQL  = "SELECT * FROM area_conocimiento";

	 private final String FETCH_SQL_BY_ID = "SELECT * FROM area_conocimiento WHERE aco_codigo = ?";

	//@SuppressWarnings("unchecked")
	@Override
	public AreaConocimiento findById(int codigo) {
		
		return (AreaConocimiento) jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object [] {codigo}, new AreaConocimientoMapper());
	}

	@Override
	public AreaConocimiento findByNombre(String nombre) {
		
		return null;
	}

	@Override
	public AreaConocimiento createAreaConocimiento(final AreaConocimiento areaConocimiento) {
		
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, areaConocimiento.getNombre());
				ps.setString(2, areaConocimiento.getDescripcion());
				return ps;
			}
		}, holder);

		int newAreaConocimeitoId = holder.getKey().intValue();
		System.out.println("newAreaConocimientoCod: " + newAreaConocimeitoId);
		areaConocimiento.setCodigo(newAreaConocimeitoId);
		return areaConocimiento;
	}

	@Override
	public AreaConocimiento updateAreaConocimiento(AreaConocimiento areaConocimiento) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SLQ);
				ps.setString(1, areaConocimiento.getNombre());
				ps.setString(2, areaConocimiento.getDescripcion());
				ps.setInt(3, areaConocimiento.getCodigo());
				return ps;
			}
		});
		
		return areaConocimiento;
	}

	@Override
	public void deleteAreaConocimientoById(long codigo) {
		
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
	public List<AreaConocimiento> findAllAreasConocimiento() {
		
		return jdbcTemplate.query(FETCH_SQL, new AreaConocimientoMapper());
	}

	@Override
	public boolean ifAreaConocimientoExist(AreaConocimiento areaConocimiento) {
		
		return false;
	}

}
