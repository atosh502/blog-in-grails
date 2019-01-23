import blog2.JwtCookieTokenReader
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler

// Place your Spring DSL code here
beans = {
    tokenReader(JwtCookieTokenReader){
        cookieName = 'jwt'
    }

    cookieClearingLogoutHandler(CookieClearingLogoutHandler, ['jwt'])
}
