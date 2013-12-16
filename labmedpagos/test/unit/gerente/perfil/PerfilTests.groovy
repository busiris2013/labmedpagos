package gerente.perfil



import gerenciageneral.GerenteGeneral
import gerente.perfil.Perfil;
import grails.test.mixin.*
import labmed.createcommands.PerfilCreateCommand

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Perfil)
class PerfilTests {

    void testConstraints() {
		
		def gerenteGeneral = mockFor(GerenteGeneral)
		
		def perfil = new Perfil(nombres:"Roberto Jose",
			apellidos: "Alvarez Ferrari",
			dni: "32359525",
		   edad: 27,sexo: "masculino",
		   email: "omsidium@gmail.com", gerente:gerenteGeneral)
		 mockForConstraintsTests(Perfil, [perfil])
		 
		 assertTrue perfil.validate()
		 
		  perfil = new Perfil(nombres:"Roberto Jose",
			 apellidos: "Alvarez Fer6666",
			 dni: "32355",
			edad: 98,sexo: "masc",
			email: "omsidiugmacom", gerente:gerenteGeneral)
		 assertFalse perfil.validate()
		 assertEquals  null, perfil.errors["nombres"] 
		 assertEquals  "matches", perfil.errors["apellidos"]
		 assertEquals  "size", perfil.errors["dni"]
		 assertEquals  "max", perfil.errors["edad"]
		 assertEquals "inList", perfil.errors["sexo"]
		 assertEquals "email", perfil.errors["email"]
		 
		 perfil = new Perfil(nombres:"Roberto Jo99",
			 apellidos: "Alvarez Fer6666",
			 dni: "3235587o",
			edad: 98,sexo: "masc",
			email: "omsidiugmacom", gerente:gerenteGeneral)
		 assertFalse perfil.validate()
		 assertEquals  "matches", perfil.errors["nombres"]
		 assertEquals  "matches", perfil.errors["apellidos"]
		 assertEquals  "matches", perfil.errors["dni"]
		 assertEquals  "max", perfil.errors["edad"]
		 assertEquals "inList", perfil.errors["sexo"]
		 assertEquals "email", perfil.errors["email"]
            }
	void testConstraintsCommand() {
		def gerenteGeneral = GerenteGeneral.getGerenteGeneral("gerenteGeneral", "password")
		def perfilCreateCommand = new PerfilCreateCommand(nombres:"Roberto Jose",
			apellidos: "Alvarez Ferrari",
			dni: "32359525",
		   edad: 27,sexo: "masculino",
		   email: "omsidium@gmail.com")
		def perfil = new Perfil(perfilCreateCommand,gerenteGeneral)
		mockForConstraintsTests(Perfil, [perfil])
		assertTrue perfil.validate()
		 
		  perfilCreateCommand = new PerfilCreateCommand(nombres:"Roberto Jose",
			 apellidos: "Alvarez Fer6666",
			 dni: "32355",
			edad: 98,sexo: "masc",
			email: "omsidiugmacom")
		  perfil = new Perfil(perfilCreateCommand, gerenteGeneral)
		 assertFalse perfil.validate()
		 assertEquals  null, perfil.errors["nombres"]
		 assertEquals  "matches", perfil.errors["apellidos"]
		 assertEquals  "size", perfil.errors["dni"]
		 assertEquals  "max", perfil.errors["edad"]
		 assertEquals "inList", perfil.errors["sexo"]
		 assertEquals "email", perfil.errors["email"]
		 
		 perfilCreateCommand = new PerfilCreateCommand(nombres:"Roberto Jo99",
			 apellidos: "Alvarez Fer6666",
			 dni: "3235587o",
			edad: 98,sexo: "masc",
			email: "omsidiugmacom")
		 perfil = new Perfil(perfilCreateCommand, gerenteGeneral)
		 assertFalse perfil.validate()
		 assertEquals  "matches", perfil.errors["nombres"]
		 assertEquals  "matches", perfil.errors["apellidos"]
		 assertEquals  "matches", perfil.errors["dni"]
		 assertEquals  "max", perfil.errors["edad"]
		 assertEquals "inList", perfil.errors["sexo"]
		 assertEquals "email", perfil.errors["email"]
			}
	
	}
	

