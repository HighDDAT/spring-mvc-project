<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>

<%@ include file="../../include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <%@ include file="../../include/main_header.jsp"%>
  
  <!-- Left side column. contains the logo and sidebar -->
  <%@ include file="../../include/left_column.jsp"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Page Header
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <div class="col-lg-12">
	    <div class="box box-primary">
	        <div class="box-header with-border">
	            <h3 class="box-title">게시글 목록</h3>
	        </div>
	        <div class="box-body">
	            <table class="table table-bordered">
	                <tbody>
	                <tr>
	                    <th style="width: 30px">#</th>
	                    <th>제목</th>
	                    <th style="width: 100px">작성자</th>
	                    <th style="width: 150px">작성시간</th>
	                    <th style="width: 60px">조회</th>
	                </tr>
	                <c:forEach items="${articles}" var="article">
	                <tr>
					    <td>${article.articleNo}</td>
					    <td>
					      <a href="${path}/article/paging/read${pageMaker.makeQuery(pageMaker.criteria.page)}&articleNo=${article.articleNo}">
					        ${article.title}
					      </a>
					    </td>
					    <td>${article.writer}</td>
					    <td><fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd a HH:mm"/></td>
					    <td><span class="badge bg-red">${article.viewCnt}</span></td>
					</tr>
	                </c:forEach>
	                </tbody>
	            </table>
	        </div>
	        
	        <!-- 페이지 번호 출력 -->
	        <div class="box-footer">
			    <div class="text-center">
				    <form id="listPageForm">
					    <input type="hidden" name="page" value="${pageMaker.criteria.page}">
					    <input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum}">
					</form>
			        <ul class="pagination">
					    <c:if test="${pageMaker.prev}">
					        <li><a href="${pageMaker.startPage - 1}">이전</a></li>
					    </c:if>
					    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					        <li <c:out value="${pageMaker.criteria.page == idx ? 'class=active' : ''}"/>>
					            <a href="${idx}">${idx}</a>
					        </li>
					    </c:forEach>
					    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					        <li><a href="${pageMaker.endPage + 1}">다음</a></li>
					    </c:if>
					</ul>
			    </div>
			</div>
	        
	        <div class="box-footer">
	            <div class="pull-right">
	                <button type="button" class="btn btn-success btn-flat" id="writeBtn">
	                    <i class="fa fa-pencil"></i> 글쓰기
	                </button>
	            </div>
	        </div>
	    </div>
	</div>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <%@ include file="../../include/main_footer.jsp"%>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<%@ include file = "../../include/plugin_js.jsp" %>

<script>
	$("#writeBtn").on("click", function (event) {
	    self.location = "/article/paging/write";
	});
	var result = "${msg}";
		if (result == "regSuccess") {
		    alert("게시글 등록이 완료되었습니다.");
		} else if (result == "modSuccess") {
		    alert("게시글 수정이 완료되었습니다.");
		} else if (result == "delSuccess") {
		    alert("게시글 삭제가 완료되었습니다.");
		}
	$(".pagination li a").on("click", function (event) {
		  event.preventDefault();
		    var targetPage = $(this).attr("href");
		    var listPageForm = $("#listPageForm");
		    listPageForm.find("[name='page']").val(targetPage);
		    listPageForm.attr("action", "/article/paging/list").attr("method", "get");
		    listPageForm.submit();
	});	
</script>

</body>
</html>