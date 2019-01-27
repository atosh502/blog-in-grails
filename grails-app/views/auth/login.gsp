<html>
    <head>
        <meta name="layout" content="cleanMain" />
        <title>Login</title>
    </head>

    <body>

        <div class="container-fluid">
            <nav class="navbar navbar-default">
                <div class="container-fluid">

                    <div class="navbar-header">
                        <a class="navbar-brand" href="/post/index">Blog</a>
                    </div>

                </div>
            </nav>

            <sec:ifNotLoggedIn>
                Login first!
            </sec:ifNotLoggedIn>

            <sec:ifLoggedIn>
                You're now logged in: goto <a href="/post/index">Blog</a>
            </sec:ifLoggedIn>

        </div>

        <div class="myFooter container-fluid">

            <sec:ifNotLoggedIn>
                <a href="/oauth/authenticate/google">Login with Google</a>
            </sec:ifNotLoggedIn>

            <sec:ifLoggedIn>
                Currently logged in as: ${applicationContext.springSecurityService.principal.userProfile.displayName}
                <form id="myForm" action="/logout/index" method="post">
                    <input type="hidden" name="hiddenField" value="doesnt_matter" />
                    <a href="#" onclick="document.getElementById('myForm').submit();">Logout</a>
                </form>

            </sec:ifLoggedIn>

        </div>

    </body>

</html>