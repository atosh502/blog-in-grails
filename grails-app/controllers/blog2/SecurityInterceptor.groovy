//package blog2
//
//import grails.plugin.springsecurity.SpringSecurityService
//
//class SecurityInterceptor {
//
//    SpringSecurityService springSecurityService
//
//    SecurityInterceptor(){
//        matchAll()
//        .except(controller: "user", action: "login")
//    }
//
//    boolean before() {
//        // if the user isn't logged in and the action is not authenticate then redirect to login
//
//        if (!session.user && actionName != "authenticate"){
////            println "Something is not right here!"
//            redirect(controller: "user", action: "login")
//            return false
//        }
////        println "User has successfully logged in!"
//        return true
//    }
//
//    boolean after() { true }
//
//    void afterView() {
//        // no-op
//    }
//}

// now we can handle authentication with the help of spring security