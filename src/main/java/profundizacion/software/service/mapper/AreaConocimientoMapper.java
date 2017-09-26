package profundizacion.software.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import profundizacion.software.model.AreaConocimiento;

public class AreaConocimientoMapper implements RowMapper{
	
	public AreaConocimiento mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		AreaConocimiento areaConocimiento = new AreaConocimiento();
		areaConocimiento.setCodigo(rs.getInt("aco_codigo"));
		areaConocimiento.setNombre(rs.getString("aco_nombre"));
		areaConocimiento.setDescripcion(rs.getString("aco_descripcion"));
		
		return areaConocimiento;
	}

	

}
