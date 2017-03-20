<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="collapse navbar-collapse project_menu" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a onclick="location.reload()">프로젝트 정보</a></li>
        <li><a onclick="viewIssue()">게시판(이슈)</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown  Example<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
</div>

<div class = "panel-primary view">
	<div class="panel-heading">
		프로젝트 제목 : ${ entity.prjt_sbjt }
	</div>
	<div class="panel-body">
		프로젝트 내용 : ${ entity.prjt_conts }
	</div>
</div>
<form id = "issueView" action = "/issue/view"  method="post">
	<input type = "hidden" name = "prjt_idx" value = ${ entity.prjt_idx }>
</form>
	