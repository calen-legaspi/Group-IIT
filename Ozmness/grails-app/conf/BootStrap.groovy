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

        /*Project p = new Project()
        p.name = "Project X"
        Employee e = new Employee()
        e.firstName = "Awesome"
        e.lastName = "Not Awesome"
        e.position = Position.get(1)
        e.add
        e.addToProjects(p)
        p.save()
        e.save()*/
	}

	def destroy = {
	}
}
