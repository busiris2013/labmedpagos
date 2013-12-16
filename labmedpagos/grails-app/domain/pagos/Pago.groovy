package pagos
import pagos.cadete.Cadete
class Pago {

	static belongsTo = [cadete: Cadete, gerenteDePagos: GerenteDePagos]
	
    static	mapping = {
    }
    
	static	constraints = {
    }
	

}
