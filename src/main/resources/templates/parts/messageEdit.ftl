<#include "security.ftl">

<div>
    Message editor

    <form method="post" >
        <input type="text" name="text" placeholder="Input text" required value="<#if message??>${message.text}</#if>">
        <input type="text" name="tag" placeholder="Tag" value="<#if message??>${message.tag}</#if>">

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="id" value="<#if message??>${message.id}</#if>"/>
        <button type="submit">Add message</button>
    </form>
</div>