<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="cleanMain" />
    <title>Show all archived Posts</title>
</head>

<body>

<div class="container-fluid">
    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="navbar-header">
                <a class="navbar-brand" href="/post/index">Blog</a>
            </div>

            <ul class="nav navbar-nav">
                <li><a href="/post/create">Create Post</a></li>
            </ul>
        </div>
    </nav>

    <table class="table">
        <thead>
        <tr>
            <th>Title</th>
            <th>Text</th>
        </tr>
        </thead>

        <tbody>
        <g:each in="${postList}" var="post">
            <tr>
                <td>${post.title}</td>
                <td>${post.text}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

<div class="myFooter container-fluid">
    <sec:ifLoggedIn>
        Currently logged in as: ${applicationContext.springSecurityService.principal.userProfile.displayName}
        <form id="myForm" action="/logout/index" method="post" style="display: inline;">
            <input type="hidden" name="hiddenField" value="doesnt_matter" />
            <a href="#" onclick="document.getElementById('myForm').submit();">Logout</a>
        </form>

    </sec:ifLoggedIn>
</div>

</body>
</html>