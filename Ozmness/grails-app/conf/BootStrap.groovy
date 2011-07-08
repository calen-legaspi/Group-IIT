import com.orangeandbronze.ozmness.*

class BootStrap {
    def springSecurityService

    def init = { servletContext ->
		def roles = [:]
		def users = [:]

		roles.admin = Role.findByAuthority("ADMIN") ?: new Role(authority: "ADMIN").save();

		users.admin = User.findByUsername('admin') ?:
			new User(
				username: 'admin',
				password: springSecurityService.encodePassword('admin'),
				enabled: true,
				accountExpired:false,
				accountLocked: false,
				passwordExpired: false
			).save();

		UserRole.create( users.admin, roles.admin )
	}

	def destroy = {
	}
}
