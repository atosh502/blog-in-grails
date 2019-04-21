package blog2

import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
class EmailController {

    def index(){}

    def send() {
        println params
        sendMail {
            println params
            to params.address
            subject params.subject
            text params.body
        }

        flash.message = "Message sent at " + new Date()
        redirect action: "index"
    }
}
