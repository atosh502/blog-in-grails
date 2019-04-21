package blog2

import grails.testing.web.UrlMappingsUnitTest
import spock.lang.Specification

class UrlMappingsSpec extends Specification implements UrlMappingsUnitTest<UrlMappings> {

    void setup() {
        mockController(PostController)
    }

    void "post/search endpoint mapping includes query term in path"() {
        expect:
        verifyForwardUrlMapping("/post/search/grails", controller: 'post', action: 'search') {
            query = 'grails'
        }
    }
}