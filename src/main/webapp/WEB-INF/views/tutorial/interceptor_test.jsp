<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>

<%@ include file="../include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <%@ include file="../include/main_header.jsp"%>
  
  <!-- Left side column. contains the logo and sidebar -->
  <%@ include file="../include/left_column.jsp"%>

   <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                인터셉터 테스트
            </h1>
            <ol class="breadcrumb">
                <li><i class="fa fa-edit"></i> interceptor test</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

           <div class="col-lg-12">
			    <div class="box box-primary">
			        <div class="box-header with-border">
			            <h3 class="box-title">인터셉터 결과 데이터</h3>
			        </div>
			        <div class="box-body">
			            <a href="${path}/interceptor/doB">doB 페이지로 이동</a>
			        </div>
			        <div class="box-footer">
			            <p>결과데이터 : ${result}</p>
			        </div>
			    </div>
			</div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@ include file="../include/main_footer.jsp"%>

</div>
<!-- ./wrapper -->
<%@ include file="../include/plugin_js.jsp"%>



</body>
</html>