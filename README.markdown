# Motivations

Easily setup a GAE project using:
* VRaptor
* Objectify
* Guice with static scan
* JSON REST with Gson

# Setup

    $ git clone git://github.com/bfuster/vraptor-gaeofy-blank.git
    $ export GAE_SDK=/Developer/appengine/current
    $ ant runserver
    $ open http://localhost:8080

# Creating REST resources

## Sample entity

	public class User {
	
		@Id Long id;
		String name;

		public User() {}

		public User(String name) {
			this.name = name;
		}
	
		/* getters n setters */

	}


## Registering entites

@Component
@ApplicationScoped
public class ObjectifyRegister {
	
	static {
		
		GAEOfy.register(User.class, "user");
	}

}

## Controller

	@Resource
	public class IndexController {

		private final Result result;
		private final DataStoreTemplate ds;

		public IndexController(Result result, DataStoreTemplate ds) {
			this.result = result;
			this.ds = ds;
		}

		@Consumes 
		@Post("/user")
		public void index(User user) {
			ds.save(user);
			ok();
		}

		@Get("/user")
		public void list() {     
			List<User> users = ds.query(User.class).limit(10).list();
			result.use(json()).from(users, "users").serialize();
		}

		private void ok() {
			result.use(status()).ok();
		}
	}

## cURL

	$ curl -v -H "Content-Type:application/json" -X POST -d '{"user":{"name":"test"}}' http://localhost:8080/user
	$ curl -X GET http://localhost:8080/user