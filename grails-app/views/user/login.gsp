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

            <sec:ifLoggedIn>

                <form id="myForm" action="/logout/index" method="post" style="display: inline;">
                    <input type="hidden" name="hiddenField" value="doesnt_matter" />
                    <a href="#" onclick="document.getElementById('myForm').submit();">Logout</a>
                </form>

            </sec:ifLoggedIn>

            <sec:ifNotLoggedIn>

                <form action="/user/authenticate" method="post">

                    <div class="form-group">
                        <label for="userName">Username:</label>
                        <input type="text" class="form-control" id="userName" placeholder="Username" name="userName">
                    </div>

                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input class="form-control" id="password" placeholder="Password" name="password" type="password">
                    </div>

                    <input class="btn btn-primary" type="submit" value="Submit" name="submit">

                </form>
                <br>
                <a href="/oauth/authenticate/google" class="btn btn-primary">Login with Google</a>

            </sec:ifNotLoggedIn>

        </div>

    </body>

</html>