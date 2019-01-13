package blog2

import grails.gorm.transactions.Transactional

@Transactional
class PostService {

    def get(Long id){
        Post.get(id)
    }

    def list(){
        Post.list()
    }

    def save(Post post){
        post.save()
    }

    def delete(Long id){
        Post.get(id).delete()
    }

    def update(Post post){
        post.save()
    }
}
