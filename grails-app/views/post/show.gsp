<!DOCTYPE html>
<html>

    <head>
        <meta name="layout" content="main" />
    </head>

    <body>

        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="list" action="index">Posts list</g:link></li>
            </ul>
        </div>

        <div id="show-post" class="content scaffold-show" role="main">

            <f:display bean="post" />

            <g:form resource="${this.post}" method="DELETE" class="xform">
                <fieldset class="buttons">
                    <input class="delete" type="submit" value="Delete"/>
                </fieldset>
            </g:form>

            <g:form resource="${this.post}" method="PUT" class="xform">
                <fieldset class="buttons">
                    <input class="edit" type="submit" value="Update" />
                </fieldset>
            </g:form>

        </div>

    </body>
</html>