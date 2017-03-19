<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sec:authorize access="isFullyAuthenticated()">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
           aria-expanded="false"><sec:authentication property="principal.username"/> <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Profile</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="<c:url value="/logout"/>">
                <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Logout</a></li>
        </ul>
    </li>
</sec:authorize>