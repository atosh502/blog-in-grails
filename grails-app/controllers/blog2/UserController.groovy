package blog2

class UserController {

    def userService

    def login(){
        // redirect to the login page
    }

    def authenticate(){
        def user = User.findByUserNameAndPassword(params.userName, params.password)
        if (user){
            session.user = user
            println "${user.userName} has logged in successfully!"
            redirect(controller: "post", action: "index")
        } else {
            println "Username or password mismatch"
            redirect(action: "login", controller: "user")
        }
    }

    def logout(){
        println "${session.user.userName} has logged out"
        session.user = null
        redirect(action: "index", controller: "post")
    }
}
