<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>
<#if know>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getFirstName()
    isAdmin = user.isAdmin()
    >
<#else>
    <#assign
    name = "guest"
    isAdmin = false
    >
</#if>

