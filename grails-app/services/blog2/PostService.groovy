package blog2

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService
import org.grails.web.json.JSONObject
import org.springframework.security.core.context.SecurityContextHolder

import javax.servlet.ServletContext
import java.security.Principal

@Transactional
class PostService {

//    def userService
    static SpringSecurityService springSecurityService

    def get(Long id){
        Post.get(id)
    }

    def list(){
        Post.list()
    }

    def edit(Long postId, String title, String text){
        Post post = Post.get(postId)
        post.title = title
        post.text = text
        post.save(failOnError: true, flush: true)
    }

    def save(String userId, String title, String text){
//        User user = userService.get(id)
//        println user.id
        new Post(userId: userId, title: title, text: text).save(failOnError: true, flush: true)
    }

    def delete(Long id){
        Post.get(id).delete(failOnError: true, flush: true)
    }

    def update(Post post){
        post.save(failOnError: true, flush: true)
    }

    def archived(){
        def results = Post.withDeleted { Post.findAll{deleted == true} }
        println results
        return results
    }
}


