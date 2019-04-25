package blog2

import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
class EmailController {

    def index(){}

    def send() {

        def multipartFile = request.getFile('attachment')
        def emails = params.address.tokenize()

        for (email in emails){

            sendMail {

                multipart true
                to email
                subject params.subject
                html view: "/email/template", model: [email: email, message: params.body]

                if (multipartFile && !multipartFile.empty){
                    File tmpFile = new File(System.getProperty("java.io.tmpdir")) + System.getProperty("file.separator") +
                            multipartFile.getOriginalFilename()
                    multipartFile.transferTo(tmpFile)
                    attach tmpFile
                }
            }
        }

        flash.message = "Message sent at " + new Date()
        redirect action: "index"
    }
}
