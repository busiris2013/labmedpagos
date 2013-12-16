package labmed.createcommands

class GerenteCreateCommand {
	String username
	String password
	String confirmPassword
	static constraints = {
		username blank:false
		password blank: false ,size:8..13,
		validator: {pass -> pass == confirmPassword}
		}
}
