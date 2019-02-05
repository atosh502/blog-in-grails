package blog2

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.rest.token.reader.TokenReader
import groovy.util.logging.Slf4j
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.core.context.SecurityContextHolder

import javax.servlet.http.Cookie
import javax.xml.bind.DatatypeConverter

@Slf4j
class AuthController implements GrailsConfigurationAware{

    TokenReader tokenReader
    int jwtExpiration

    String grailsServerUrl

    static allowedMethods = [success: 'GET', logout: 'POST']

    // anonymous access allowed at /auth/success

    @Secured('permitAll')
    def login(){
        redirect(action: 'login', controller: 'auth')
    }

    @Secured('permitAll')
    def success(String token) {
        log.debug("Token value {}", token)
        if (token) {
            Cookie cookie = jwtCookie(token)
            response.addCookie(cookie)
        }

        [grailsServerUrl: grailsServerUrl]
    }

    protected Cookie jwtCookie(String tokenValue){
        Cookie jwtCookie = new Cookie(cookieName(), tokenValue)
        jwtCookie.maxAge = jwtExpiration
        jwtCookie.path = '/'
        jwtCookie.setHttpOnly(true)
        if (httpOnly()){
            jwtCookie.setSecure(true)
        }

        return jwtCookie
    }

    @Override
    void setConfiguration(Config co) {
        jwtExpiration = co.getProperty('grails.plugin.springsecurity.rest.token.storage.memcached.expiration', Integer, 3600)
        grailsServerUrl = co.getProperty('grails.serverURL', String)
    }

    protected boolean httpOnly(){
        grailsServerUrl?.startsWith('https')
    }

    protected String cookieName(){
        if (tokenReader instanceof JwtCookieTokenReader){
            return ((JwtCookieTokenReader) tokenReader).cookieName
        }
        return 'jwt'
    }
}
