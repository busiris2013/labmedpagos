package gerenciageneral
import gerente.Gerente
import gerente.perfil.Perfil;
//import grails.plugin.springsecurity.SpringSecurityService
//import grails.plugin.springsecurity.authentication.encoding.BCryptPasswordEncoder
import labmed.createcommands.GerenteCreateCommand

class GerenteGeneral extends Gerente {
	static def gerenteGeneral = null
	static def getGerenteGeneral(String username, String password) {
		if (!gerenteGeneral)gerenteGeneral = new GerenteGeneral(username, password)
		gerenteGeneral
	}
	
	private GerenteGeneral() {}
	
	private GerenteGeneral (Map map) {}	
	
	private GerenteGeneral(String username, String password) {
		//def springSecurityService = new SpringSecurityService(passwordEncoder:
			//new BCryptPasswordEncoder(10))
		setUsername(username)
		//setPassword(springSecurityService.encodePassword(password))
		setPassword(password)
		enabled = true	
	}	
	
    static constraints = {
    }
}
