package blog2

import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
class EmailController {

    def index(){}

    def send() {

        def multipartFile = request.getFile('attachment')

        sendMail {

            multipart true

            to params.address
            subject params.subject
            text params.body

            if (multipartFile && !multipartFile.empty){
                File tmpFile = new File(System.getProperty("java.io.tmpdir") +
                        System.getProperty("file.separator") + multipartFile.getOriginalFilename());
                multipartFile.transferTo(tmpFile)
                attach tmpFile
            }
        }

        flash.message = "Message sent at " + new Date()
        redirect action: "index"
    }
}
