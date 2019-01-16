package blog2

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def get(id){
        User.get(id)
    }

    def list(){
        User.list()
    }

    def save(user){
        user.save()
    }

    def delete(id){
        User.get(id).delete()
    }
}
