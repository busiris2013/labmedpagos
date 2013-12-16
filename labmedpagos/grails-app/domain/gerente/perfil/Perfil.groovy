package gerente.perfil
import labmed.createcommands.PerfilCreateCommand
import gerente.Gerente
class Perfil {
	String  nombres
	String  apellidos
	String  dni
	Integer edad
	String  sexo
	String email
	static belongsTo = [gerente:Gerente]
	static	constraints = {
		nombres blank:false, size:3..20 , matches:/\w+\D \w+\D/
		apellidos blank: false, size:3..20, matches:/\w+\D \w+\D/
		dni blank: false, size:7..8, matches:/\d\d\d\d\d\d\d+/
		edad blank: false, min:21, max: 85
		sexo blank: false, inList: ["masculino", "femenino"]
		email email: true
		
				
    }
	public Perfil(PerfilCreateCommand perfilCommand, Gerente gerente) {
		nombres = perfilCommand.getNombres()
		apellidos = perfilCommand.getApellidos()
		dni = perfilCommand.getDni()
		edad = perfilCommand.getEdad()
		sexo = perfilCommand.getSexo()
		email = perfilCommand.getEmail()
		this.gerente = gerente
	}
}
