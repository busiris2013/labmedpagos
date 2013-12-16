package pagos
import gerente.Gerente
import gerente.perfil.Perfil;
import labmed.createcommands.PerfilCreateCommand
import labmed.createcommands.GerenteCreateCommand
class GerenteDePagos extends Gerente {

    static constraints = {
    }
	static public def getGerenteDePagos(GerenteCreateCommand command) {
		if(!gerenteDePagos)gerenteDePagos = 
		new GerenteDePagos(command)
		gerenteDePagos
		}
	static public def getGerenteDePagos() {
		gerenteDePagos
		}
	static public def darDeBaJa() {
		gerenteDePagos = null
		}
	
	public def generarListadoDeExigenciasAautorizar() {
		gerenciaDePagos.generarListadoDeExigenciasAautorizar()
	}
	public def generarListadoDeExigenciasRechazadas() {
		gerenciaDePagos.generarListadoDeExigenciasRechazadas()
	}
	static private  def gerenteDePagos = null
	
	
	
	private GerenteDePagos(GerenteCreateCommand command) {
		this.setUsername(command.username)
		this.setPassword(this.encodePassword(command.password))
	
		}
	private GerenteDePagos() {}
	
	private GerenteDePagos(Map map) {
		this.properties = map.values.toList()
	}
	
	
}
