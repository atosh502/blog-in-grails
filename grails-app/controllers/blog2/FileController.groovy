package blog2

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.web.multipart.MultipartFile

import java.text.DateFormat
import java.text.SimpleDateFormat

// TODO: change this to reflect the change in Post and User domain classes
@Secured('permitAll')
class FileController {

    def index() {
        redirect(action: 'upload')
    }

    def fileUpload(){
        MultipartFile file = request.getFile('myCSVFile')
        if (file.empty){
            render(view: 'upload')
            return
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.inputStream, "UTF-8"));

        reader.readLine()   // skip the first line

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")

        reader.splitEachLine(',') { fields ->

            def updatedPost = new UpdatedPost(title: fields[1].trim(),
                                                text: fields[2].trim(),
                                                user: User.findByFullName(fields[3].trim()),
                                                date: new Date(fields[4].trim()),
                                                path: fields[5].trim())

//            def userRole = new UserRole(userId: fields[3].trim(), userRole: fields[6].trim())

            updatedPost.save(flush: true, failOnError: true)
//            userRole.save(flush: true, failOnError: true)

        }

        redirect(action: 'index', controller: 'post')
    }

    def upload(){}  // just return the upload.gsp view

    def display(){} // render the display.gsp view

}
