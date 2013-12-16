package pagos
import proveedor.Proveedor
import java.util.Date
class ExigenciaDePago {
	String nombreProveedor
	Date fechaDeVencimiento
	Integer monto
	static belongsTo = [proveedor: Proveedor, gerenteDePagos: GerenteDePagos]
    static constraints = {
		nombreProveedor size:3..20,alfanumeric:true
		fechaDeVencimiento max: new Date()
		monto min: 1000, max: 10000
    }
	
}
