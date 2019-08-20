<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>
<#include "parts/security.ftl">


<@mymacro.page>

    <h5>Hello ${name} <#if isAdmin>you are ADMIN !</#if></h5>
    <div>This my first registration form</div>
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Input text" required>
        <input type="text" name="tag" placeholder="Tag">

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Add message</button>
    </form>
</div>

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
            <td>${message.tag}</td>
            <td>${message.auth.firstName}</td>
        </tr>
    <#else >
        No Message
    </#list>

</@mymacro.page>
