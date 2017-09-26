package profundizacion.software.model;

public class Pregunta {
	
	long codigo;
	String enunciado;
	String opcion1;
	String opcion2;
	String opcion3;
	String opcion4;
	String opcion5;
	String respuesta;
	int codAreaConocimiento;
	
	
	public Pregunta(){
		super();
	} 
	
	public Pregunta(long codigo, String enunciado, String opcion1, String opcion2, String opcion3, String opcion4,
			String opcion5, String respuesta, int codAreaConocimiento) {
		super();
		this.codigo = codigo;
		this.enunciado = enunciado;
		this.opcion1 = opcion1;
		this.opcion2 = opcion2;
		this.opcion3 = opcion3;
		this.opcion4 = opcion4;
		this.opcion5 = opcion5;
		this.respuesta = respuesta;
		this.codAreaConocimiento = codAreaConocimiento;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getOpcion1() {
		return opcion1;
	}
	public void setOpcion1(String opcion1) {
		this.opcion1 = opcion1;
	}
	public String getOpcion2() {
		return opcion2;
	}
	public void setOpcion2(String opcion2) {
		this.opcion2 = opcion2;
	}
	public String getOpcion3() {
		return opcion3;
	}
	public void setOpcion3(String opcion3) {
		this.opcion3 = opcion3;
	}
	public String getOpcion4() {
		return opcion4;
	}
	public void setOpcion4(String opcion4) {
		this.opcion4 = opcion4;
	}
	public String getOpcion5() {
		return opcion5;
	}
	public void setOpcion5(String opcion5) {
		this.opcion5 = opcion5;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public int getCodAreaConocimiento() {
		return codAreaConocimiento;
	}
	public void setCodAreaConocimiento(int codAreaConocimiento) {
		this.codAreaConocimiento = codAreaConocimiento;
	}
	
	
	
	
	
}
