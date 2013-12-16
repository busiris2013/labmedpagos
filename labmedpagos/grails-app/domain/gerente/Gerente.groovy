package gerente
import gerente.perfil.Perfil;

//import org.springframework.aop.aspectj.RuntimeTestWalker.ThisInstanceOfResidueTestVisitor;

//import labmed.security.SecUser

class Gerente  {
	  Perfil perfil
	  String username
	  String password
    static constraints = {
		perfil nullable:true
    }
}