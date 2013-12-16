package pagos
import labmed.createcommands.PerfilCreateCommand
import labmed.createcommands.GerenteCreateCommand
//import org.springframework.security.access.annotation.Secured
/**
 * GerenteDePagosSingUpController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */

class GerenteDePagosController {
	static scaffold = true
	def index = { render view: 'register'}
	
	//@Secured(["ROLE_PAGOS"])
	def home() {
		
	}
	
	//@Secured(["ROLE_ADMIN"])
	def register() {
		if (GerenteDePagos.count > 0) 
		render view: 'gerenteYaRegistrado'
		else {
		def gerenteCreateCommand = new GerenteCreateCommand(params)
		if (!gerenteCreateCommand.hasErrors()) {
			servletContext["gerenteCreateCommand"] = gerenteCreateCommand
			render view: 'llenarPerfil'
			}
		else render view: 'errorRegistering', 
		model :[gerenteCreateCommand: gerenteCreateCommand]
		
		}
	}
	
	//@Secured(["PERMIT_ALL"])
	def llenarPerfil() {
		def perfilCreateCommand = new PerfilCreateCommand(params)
		if (!perfilCreateCommand.hasErrors()) {
			def gerenteDePagosCreateCommand = servletContext["gerenteCreateCommand"]
			def gerenteDePagos = GerenteDePagos.getGerenteDePagos(gerenteDePagosCreateCommand,
				perfilCreateCommand)
	    	if (gerenteDepagos.save()) redirect action:'home'
			else { 
				render view: 'errorSaving' ,model : [gerenteDePagos : GerenteDePagos]
				GerenteDePagos.darDeBaJa()
			}			
		}		
	}

		def cancelRegister() {}
	def generarListadosDeExigencias() {
		def listadoDeExigenciasAautorizar = GerenteDePagos.getGerenteDePagos()
		}
	
	def darDeBaja() {
		GerenteDePagos.darDeBaJa()
	}
}