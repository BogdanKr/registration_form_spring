<#include "security.ftl">

<div>Message list</div>
<table>
    <thead>
    <tr>
        <th>Text</th>
        <th>Tag</th>
        <th>Author name</th>
        <th>Message likes</th>
    </tr>
    </thead>
    <tbody>
    <#list messages! as message>
        <tr>
            <td>${message.text}</td>
            <td>#${message.tag}</td>
            <td><a href="/messages/${message.auth.id}">${message.auth.firstName}</a></td>

            <td><a href="/messages/${message.id}/like">
                    <#if message.meLiked>
                    <i class="fas fa-registered"></i>
                    <#else>
                    <i class="far fa-registered"></i>
                    </#if>
                    ${message.likes}
                </a>
            </td>

            <#if (message.auth.id==currentUserId || isAdmin)>
                <td><a href="/messages/${message.auth.id}?message=${message.id}">Edit message </a></td>
            </#if>

        </tr>
    <#else >
        No Message
    </#list>
    </tbody>
</table>