package pagos.cadete
import pagos.Recibo
import finanzas.Cheque 
class Cadete {
	static hasMany = [cheques: Cheque, recibos: Recibo]
    static constraints = {
    }
}
