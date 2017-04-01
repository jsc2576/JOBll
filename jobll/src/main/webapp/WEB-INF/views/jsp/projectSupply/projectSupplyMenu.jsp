<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="view collapse navbar-collapse project_menu" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li><a class = "menu-a-tag" href="/projectInfo/projectInfoList/go">1</a></li>
        <li><a class = "menu-a-tag" onclick="viewProject()">2</a></li>
        <li class="dropdown">
          <a class = "menu-a-tag" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown  Example<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">1</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">2</a></li>
          </ul>
        </li>
      </ul>
</div>

<form id = "dataSender" method="post">
	<input type = "hidden" class = "prjt_idx" name = "prjt_idx" value = ${ entity.prjt_idx }>
</form>
	