package profundizacion.software.service;

import java.util.List;

import profundizacion.software.model.AreaConocimiento;


public interface AreaConocimientoService {
	
	AreaConocimiento findById(int codigo);
	
	AreaConocimiento findByNombre(String nombre);
	
	AreaConocimiento createAreaConocimiento (AreaConocimiento areaConocimiento);
	
	AreaConocimiento updateAreaConocimiento (AreaConocimiento areaConocimiento);
	
	void deleteAreaConocimientoById (long codigo);
	
	List<AreaConocimiento> findAllAreasConocimiento();
	
	boolean ifAreaConocimientoExist(AreaConocimiento areaConocimiento);

}
