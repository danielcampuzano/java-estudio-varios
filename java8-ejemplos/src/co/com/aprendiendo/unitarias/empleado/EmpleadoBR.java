package co.com.aprendiendo.unitarias.empleado;

public class EmpleadoBR {
	
	private float salarioBruto;
	private float salarioNeto;

	public float getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(float salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public float getSalarioNeto() {
		return salarioNeto;
	}

	public void setSalarioNeto(float salarioNeto) {
		this.salarioNeto = salarioNeto;
	}

	public float calculaSalarioBruto( String tipoEmpleado, float ventasMes, float horasExtra) {
		return 3.0f;
	}
	
	public float calculaSalarioNeto(float salarioBruto) {
		return 3.0f;
	}
	
}
