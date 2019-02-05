package blog2

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService
import org.grails.web.json.JSONObject
import org.springframework.security.core.context.SecurityContextHolder

import javax.servlet.ServletContext
import java.security.Principal

@Transactional
class PostService {

    def get(Long id){
        Post.get(id)
    }

    def list(){

        // entry after login - check if the user already exists in the database otherwise add the user to the db
        def map = SecurityContextHolder.getContext().getAuthentication().getPrincipal().getProperties()
        User user = User.findByUserName(map.username);

        if (user == null){
            // a new user
            new User(fullName: map.userProfile.displayName, userName: map.username).save(failOnError: true, flush: true);
        }

        Post.list()
    }

    def edit(Long postId, String title, String text){
        Post post = Post.get(postId)
        post.title = title
        post.text = text
        post.save(failOnError: true, flush: true)
    }

    def save(Long userId, String title, String text, String tagString){
        User user = User.get(userId)
        def tagNames = tagString.split(",").collect{ tag -> tag.trim()}
        def tags = []
        for (def tagName : tagNames){
            def tag = Tag.findByName(tagName)
            if (tag == null){
                tag = new Tag(name: tagName).save(failOnError: true, flush: true)
            }
            tags.add(tag)
        }
        new Post(user: user, title: title, text: text, tags: tags).save(failOnError: true, flush: true)
    }

    def delete(Long id){
        Post.get(id).delete(failOnError: true, flush: true)
    }

    def update(Post post){
        post.save(failOnError: true, flush: true)
    }

    def archived(){
        def results = Post.withDeleted { Post.findAll{deleted == true} }
        return results
    }

    def getPostsByTag(String tag){
        def posts =  Tag.findByName(tag).posts // returns a Set
        return posts.asList()
    }
}


