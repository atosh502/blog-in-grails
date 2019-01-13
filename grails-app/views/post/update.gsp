<!DOCTYPE html>
<html>

    <head>
        <meta name="layout" content="main" />
    </head>

    <body>

        <div id="update-post" class="content scaffold-create" role="main">
            <g:form resource="${this.post}" method="POST">
                <fieldset class="form">
                    <f:all bean="post"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="edit" class="save" value="Update" />
                </fieldset>
            </g:form>
        </div>

    </body>
</html>