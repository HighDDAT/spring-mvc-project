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
	            <h3 class="box-title">글제목 : ${article.title}</h3>
	        </div>
	        <div class="box-body" style="height: 700px">
	            ${article.content}
	        </div>
	        <div class="box-footer">
	            <div class="user-block">
	                <img class="img-circle img-bordered-sm" src="/dist/img/user1-128x128.jpg" alt="user image">
	                <span class="username">
	                    <a href="#">${article.writer}</a>
	                </span>
	                <span class="description"><fmt:formatDate pattern="yyyy-MM-dd a HH:mm" value="${article.regDate}"/></span>
	            </div>
	        </div>
	        <div class="box-footer">
	            <form role="form" method="post">
	                <input type="hidden" name="articleNo" value="${article.articleNo}">
			        <input type="hidden" name="page" value="${searchCriteria.page}">
		    	    <input type="hidden" name="perPageNum" value="${searchCriteria.perPageNum}">
			        <input type="hidden" name="searchType" value="${searchCriteria.searchType}">
			        <input type="hidden" name="keyword" value="${searchCriteria.keyword}">
	            </form>
	            <button type="submit" class="btn btn-primary listBtn"><i class="fa fa-list"></i> 목록</button>
	            <div class="pull-right">
	                <button type="submit" class="btn btn-warning modBtn"><i class="fa fa-edit"></i> 수정</button>
	                <button type="submit" class="btn btn-danger delBtn"><i class="fa fa-trash"></i> 삭제</button>
	            </div>
	        </div>
	        
	        <!-- 리플 달기 -->
	        <div class="box box-warning">
			    <div class="box-header with-border">
			        <a class="link-black text-lg"><i class="fa fa-pencil"></i> 댓글작성</a>
			    </div>
			    <div class="box-body">
			        <form class="form-horizontal">
			            <div class="form-group margin">
			                <div class="col-sm-10">
			                    <textarea class="form-control" id="newReplyText" rows="3" placeholder="Reply Text" style="resize: none"></textarea>
			                </div>
			                <div class="col-sm-2">
			                    <input class="form-control" id="newReplyWriter" type="text" placeholder="Reply Writer">
			                </div>
			                <hr/>
			                <div class="col-sm-2">
			                    <button type="button" class="btn btn-primary btn-block replyAddBtn"><i class="fa fa-save"></i> 저장</button>
			                </div>
			            </div>
			        </form>
			    </div>
			</div>
			
			
			<!-- 리플 접기 -->
			<div class="box box-success collapsed-box">
			    <div class="box-header with-border">
			        <a href="" class="link-black text-lg"><i class="fa fa-comments-o margin-r-5 replyCount"></i></a>
			        <div class="box-tools">
			            <button type="button" class="btn btn-box-tool" data-widget="collapse">
			                <i class="fa fa-plus"></i>
			            </button>
			        </div>
			    </div>
			    
			    <!-- 리플 목록 -->
			    <div class="box-body repliesDiv">
			
			    </div>
			    
			    <!-- 리플 페이징 -->
			    <div class="box-footer">
			        <div class="text-center">
			            <ul class="pagination pagination-sm no-margin">
			
			            </ul>
			        </div>
			    </div>
			</div>
	        
	    </div>
	</div>

			 	<%--댓글 수정 modal 영역--%>
                <div class="modal fade" id="modModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">댓글수정</h4>
                            </div>
                            <div class="modal-body" data-rno>
                                <input type="hidden" class="replyNo"/>
                                <%--<input type="text" id="replytext" class="form-control"/>--%>
                                <textarea class="form-control" id="replyText" rows="3" style="resize: none"></textarea>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
                                <button type="button" class="btn btn-primary modalModBtn">수정</button>
                            </div>
                        </div>
                    </div>
                </div>

                <%--댓글 삭제 modal 영역--%>
                <div class="modal fade" id="delModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">댓글 삭제</h4>
                                <input type="hidden" class="rno"/>
                            </div>
                            <div class="modal-body" data-rno>
                                <p>댓글을 삭제하시겠습니까?</p>
                                <input type="hidden" class="rno"/>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">아니요.
                                </button>
                                <button type="button" class="btn btn-primary modalDelBtn">네. 삭제합니다.</button>
                            </div>
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
<script id="replyTemplate" type="text/x-handlebars-template">
    {{#each.}}
    <div class="post replyDiv" data-replyNo={{replyNo}}>
        <div class="user-block">
            <img class="img-circle img-bordered-sm" src="/dist/img/user1-128x128.jpg" alt="user image">
            <span class="username">
                <a href="#">{{replyWriter}}</a>
                <a href="#" class="float-right btn-box-tool replyDelBtn" data-toggle="modal" data-target="#delModal">
                    <i class="fa fa-times"> 삭제</i>
                </a>
                <a href="#" class="float-right btn-box-tool replyModBtn" data-toggle="modal" data-target="#modModal">
                    <i class="fa fa-edit"> 수정</i>
                </a>
            </span>
            <span class="description">{{prettifyDate regDate}}</span>
        </div>
        <div class="oldReplyText">{{replyText}}</div>
        <br/>
    </div>
    {{/each}}
</script>

<script>
$(document).ready(function () {
	// 기존 글 수정or삭제 관련 코드
    var formObj = $("form[role='form']");
    console.log(formObj);

    $(".modBtn").on("click", function () {
        formObj.attr("action", "/article/paging/search/modify");
        formObj.attr("method", "get");
        formObj.submit();
    });

    $(".delBtn").on("click", function () {
       formObj.attr("action", "/article/paging/search/remove");
       formObj.submit();
    });

    $(".listBtn").on("click", function () {
       formObj.attr("method", "get");
       formObj.attr("action", "/article/paging/search/list");
       formObj.submit();
     });
    
    
    // 댓글 관련 코드
    var articleNo = "${article.articleNo}"; // 게시글 번호
    var replyPageNum = 1; // 댓글 페이지 번호 초기화
    
    // 댓글 내용 (줄바꿈, 공백처리)
    Handlebars.registerHelper("escape", function(reply_text) {
    	var text = Handlebars.Utils.escapeExpression(reply_text);
    	
    	text = text.replace(/(\r\n|\n|\r)/gm, "<br/>");
        text = text.replace(/( )/gm, "&nbsp;");
    	
    	return new Handlebars.SafeString(text);
		
	});
    
 	// 댓글 등록일자 : 날짜/시간 2자리로 맞추기
    Handlebars.registerHelper("prettifyDate", function (timeValue) {
        var dateObj = new Date(timeValue);
        var year = dateObj.getFullYear();
        var month = dateObj.getMonth() + 1;
        var date = dateObj.getDate();
        var hours = dateObj.getHours();
        var minutes = dateObj.getMinutes();
        // 2자리 숫자로 변환
        month < 10 ? month = '0' + month : month;
        date < 10 ? date = '0' + date : date;
        hours < 10 ? hours = '0' + hours : hours;
        minutes < 10 ? minutes = '0' + minutes : minutes;
        return year + "-" + month + "-" + date + " " + hours + ":" + minutes;
    });
    
 	// 댓글 목록 함수 호출
    getReplies("/replies/" + articleNo + "/" + replyPageNum);
    
 	// 댓글 목록 함수
    function getReplies(repliesUri) {
        $.getJSON(repliesUri, function (data) {
            printReplyCount(data.pageMaker.totalCount);
            printReplies(data.replies, $(".repliesDiv"), $("#replyTemplate"));
            printReplyPaging(data.pageMaker, $(".pagination"));
        });
    }
 	
 	// 댓글 갯수 출력 함수
    function printReplyCount(totalCount) {

        var replyCount = $(".replyCount");
        var collapsedBox = $(".collapsed-box");

        // 댓글이 없으면
        if (totalCount === 0) {
            replyCount.html(" 댓글이 없습니다. 의견을 남겨주세요");
            collapsedBox.find(".btn-box-tool").remove();
            return;
        }

        // 댓글이 존재하면
        replyCount.html(" 댓글목록 (" + totalCount + ")");
        collapsedBox.find(".box-tools").html(
            "<button type='button' class='btn btn-box-tool' data-widget='collapse'>"
            + "<i class='fa fa-plus'></i>"
            + "</button>"
        );
    }
 	
 	// 댓글 목록 출력 함수
    function printReplies(replyArr, targetArea, templateObj) {
        var replyTemplate = Handlebars.compile(templateObj.html());
        var html = replyTemplate(replyArr);
        $(".replyDiv").remove();
        targetArea.html(html);
    }
 	
 	// reply paging print
	function printReplyPaging(pageMaker,targetArea) {
		var str = "";
		
		// 이전 버튼 활성화
		if(pageMaker.prev) {
			str += "<li class=\"page-item\"><a class=\"page-link\" href='"+(pageMaker.startPage-1)+"'>이전</a></li>";
			
		}
		
		// page number
		for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
	        var strCalss = pageMaker.criteria.page == i ? 'class=active' : '';
	        str += "<li class=\"page-item\" "+strCalss+"><a class=\"page-link\" href='"+i+"'>"+i+"</a></li>";
	    }
		
		// 다음 버튼 활성화
		if (pageMaker.next) {
	        str += "<li class=\"page-item\"><a class=\"page-link\" href='"+(pageMaker.endPage + 1)+"'>다음</a></li>";
	    }
        targetArea.html(str);
	} // reply paging end
	
	// relpy number click event
	$(".pagination").on("click", "li a", function (event) {
        event.preventDefault();
        replyPageNum = $(this).attr("href");
        getReplies("/replies/" + articleNo + "/" + replyPageNum);
    });
	
	// 댓글 저장 버튼 클릭 이벤트
	$(".replyAddBtn").on("click", function () {

	    // 입력 form 선택자
	    var replyWriterObj = $("#newReplyWriter");
	    var replyTextObj = $("#newReplyText");
	    var replyWriter = replyWriterObj.val();
	    var replyText = replyTextObj.val();

	    // 댓글 입력처리 수행
	    $.ajax({
	        type : "post",
	        url : "/replies/",
	        headers : {
	            "Content-Type" : "application/json",
	            "X-HTTP-Method-Override" : "POST"
	        },
	        dataType : "text",
	        data : JSON.stringify({
	            articleNo : articleNo,
	            replyWriter : replyWriter,
	            replyText : replyText
	        }),
	        success: function (result) {
	            console.log("result : " + result);
	            if (result === "regSuccess") {
	                alert("댓글이 등록되었습니다.");
	                replyPageNum = 1;  // 페이지 1로 초기화
	                getReplies("/replies/" + articleNo + "/" + replyPageNum); // 댓글 목록 호출
	                replyTextObj.val("");   // 댓글 입력창 공백처리
	                replyWriterObj.val("");   // 댓글 입력창 공백처리
	            }
	        }
	    });
	});
	
	// 댓글 수정을 위해 modal창에 선택한 댓글의 값들을 세팅
	$(".repliesDiv").on("click", ".replyDiv", function (event) {
	    var reply = $(this);
	    $(".replyNo").val(reply.attr("data-replyNo"));
	    $("#replyText").val(reply.find(".oldReplyText").text());
	});
	
	// modal 창의 댓글 수정버튼 클릭 이벤트
    $(".modalModBtn").on("click", function () {
        var replyNo = $(".replyNo").val();
        var replyText = $("#replyText").val();
        $.ajax({
            type: "put",
            url: "/replies/" + replyNo,
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "PUT"
            },
            dataType: "text",
            data: JSON.stringify({
                replyText: replyText
            }),
            success: function (result) {
                console.log("result : " + result);
                if (result === "modSuccess") {
                    alert("댓글이 수정되었습니다.");
                    getReplies("/replies/" + articleNo + "/" + replyPageNum); // 댓글 목록 호출
                    $("#modModal").modal("hide"); // modal 창 닫기
                }
            }
        })
    });

    // modal 창의 댓글 삭제버튼 클릭 이벤트
    $(".modalDelBtn").on("click", function () {
        var replyNo = $(".replyNo").val();
        $.ajax({
            type: "delete",
            url: "/replies/" + replyNo,
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "DELETE"
            },
            dataType: "text",
            success: function (result) {
                console.log("result : " + result);
                if (result === "delSuccess") {
                    alert("댓글이 삭제되었습니다.");
                    getReplies("/replies/" + articleNo + "/" + replyPageNum); // 댓글 목록 호출
                    $("#delModal").modal("hide"); // modal 창 닫기
                }
            }
        });
    });

	
	

});
</script>

</body>
</html>