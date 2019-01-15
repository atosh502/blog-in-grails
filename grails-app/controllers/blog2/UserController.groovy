package blog2

class UserController {

    def userService

    def login(){
        // redirects to login screen
    }

    def authenticate(User _user){
        def user = User.findByUserNameAndPassword(_user.userName, _user.password)
        if (user){
            session.user = user
            flash.message = "${user.userName} has logged in successfully!"
            redirect(controller: "post", action: "list")
        } else {
            flash.message = "Username or password mismatch"
            redirect(action: "login", controller: "user")
        }
    }

    def logout(){
        flash.message = "${session.user.userName} has logged out"
        session.user = null
        redirect(action: "list", controller: "post")
    }
}
