package labmed.createcommands

class PerfilCreateCommand {
	String  nombres
	String  apellidos
	String  dni
	Integer edad
	String  sexo
	String email
	static	constraints = {
		nombres blank:false, size:3..20
		apellidos blank: false, size:3..20
		dni blank: false, numeric:true, alfabetic:false, size:7..8
		edad blank: false, validator: {edad -> (edad >= 21)&&(edad <= 87)}
		sexo blank: false, inList: ["masculino", "femenino"]
		email blank: false, email:true
	}
}