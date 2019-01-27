grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/index.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails {
    plugin {
       springsecurity {
           rest {
               token {
                   validation {
                       useBearerToken = false
                       enableAnonymousAccess = true
                   }

                   storage {
                       jwt {
                           secret = "changeThisInProduction345690andItMustBeThirtyTwoCharactersLongchangeThisInProduction345690andItMustBeThirtyTwoCharactersLong"
                       }
                   }
               }

               oauth {
                   frontendCallbackUrl = {
                       String tokenValue -> "http://localhost:8080/auth/success?token=${tokenValue}"
                   }

                   google {
                       client = org.pac4j.oauth.client.Google2Client
                       key = 	"871459817804-ov5chtphrh1821dkeis3d0255ooietns.apps.googleusercontent.com"
                       secret = "fovGTI7ZQDKIJDSCqBrM9q-q"
                       scope = org.pac4j.oauth.client.Google2Client.Google2Scope.EMAIL_AND_PROFILE
                       defaultRoles = []
                   }
               }
           }
           providerNames = ["anonymousAuthenticationProvider"]
       }

        String ANONYMOUS_FILTERS = 'anonymousAuthenticationFilter,restTokenValidationFilter,restExceptionTranslationFilter,filterInvocationInterceptor'
        grails.plugin.springsecurity.filterChain.chainMap = [
                [pattern: "/dbconsole/**", filters: 'none'],
                [pattern: "/assets/**", filters: 'none'],
                [pattern: "/**/js/**", filters: 'none'],
                [pattern: "/**/css/**", filters: 'none'],
                [pattern: "/**/images/**", filters: 'none'],
                [pattern: "/**/favicon.ico", filters: 'none'],
                [pattern: "/", filters: ANONYMOUS_FILTERS],
//                [pattern: "/user/login", filters: ANONYMOUS_FILTERS],
//                [pattern: "/auth/logout", filters: ANONYMOUS_FILTERS],
//                [pattern: "/logout", filters: ANONYMOUS_FILTERS],
                [pattern: "/auth/success", filters: ANONYMOUS_FILTERS],
                [pattern: "/oauth/authenticate/google", filters: ANONYMOUS_FILTERS],
                [pattern: "/oauth/callback/google", filters: ANONYMOUS_FILTERS],
                [pattern: '/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter']
        ]
    }
}

grails.plugin.springsecurity.logout.handlerNames = ['rememberMeServices',
                                                    'securityContextLogoutHandler',
                                                    'cookieClearingLogoutHandler']