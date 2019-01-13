<!DOCTYPE html>
<html>

    <head>
        <meta name="layout" content="main" />
    </head>

    <body>

        <div id="create-post" class="content scaffold-create" role="main">
            <g:form resource="${this.post}" method="POST">
                <fieldset class="form">
                    <f:all bean="post"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="Create" />
                </fieldset>
            </g:form>
        </div>

    </body>
</html>