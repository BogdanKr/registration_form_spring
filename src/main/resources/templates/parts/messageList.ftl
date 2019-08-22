<#include "security.ftl">

<div>Message list</div>
<table>
    <thead>
    <tr>
        <th>Text</th>
        <th>Tag</th>
        <th>Author name</th>
    </tr>
    </thead>
    <tbody>
    <#list messages! as message>
        <tr>
            <td>${message.text}</td>
            <td>#${message.tag}</td>
            <td><a href="/my-messages/${message.auth.id}">${message.auth.firstName}</a></td>
            <#if (message.auth.id==user.id || isAdmin)>
                <td><a href="/my-messages/${message.auth.id}?message=${message.id}">Edit message</a></td>
            </#if>
        </tr>
    <#else >
        No Message
    </#list>
    </tbody>
</table>