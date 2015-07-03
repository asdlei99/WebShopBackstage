<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta CHARSET="utf-8">
    <title>添加图书</title>
    <meta CONTENT="IE=edge,chrome=1" HTTP-EQUIV="X-UA-Compatible">
    <meta name="viewport" CONTENT="width=device-width, initial-scale=1.0">
    <meta name="description" CONTENT="">
    <meta name="author" CONTENT="">

    <link REL="stylesheet" TYPE="text/css" HREF="lib/bootstrap/css/bootstrap.css">
    <link REL="stylesheet" TYPE="text/css" HREF="lib/bootstrap/css/bootstrap-responsive.css">
    <link REL="stylesheet" TYPE="text/css" HREF="stylesheets/theme.css">
    <link REL="stylesheet" HREF="lib/font-awesome/css/font-awesome.css">

    <script SRC="lib/jquery-1.8.1.min.js" TYPE="text/javascript"></script>

    <!-- Demo page code -->
    
    <style TYPE="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link REL="shortcut icon" HREF="../assets/ico/favicon.ico">
    <link REL="apple-touch-icon-precomposed" sizes="144x144" HREF="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link REL="apple-touch-icon-precomposed" sizes="114x114" HREF="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link REL="apple-touch-icon-precomposed" sizes="72x72" HREF="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link REL="apple-touch-icon-precomposed" HREF="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7"> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8"> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9"> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body> 
  <!--<![endif]-->
    
    <div CLASS="navbar">
        <div CLASS="navbar-inner">
            <div CLASS="container-fluid">
                <ul CLASS="nav pull-right">
                    
                    <li id="fat-menu" CLASS="dropdown">
                        <a HREF="#" id="drop3" ROLE="button" CLASS="dropdown-toggle" data-toggle="dropdown">
                            <i CLASS="icon-user"></i> Jack Smith
                            <i CLASS="icon-caret-down"></i>
                        </a>

                        <ul CLASS="dropdown-menu">
                            <li><a TABINDEX="-1" HREF="#">Settings</a></li>
                            <li CLASS="divider"></li>
                            <li><a TABINDEX="-1" HREF="sign-in.html">Logout</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a CLASS="brand" HREF="index.html"><span CLASS="first">Online</span> <span class="second">Shop</span></a>
            </div>
        </div>
    </div>
    

   <div class="container-fluid">
        
        <div CLASS="row-fluid">
            <div CLASS="span3">
                <div CLASS="sidebar-nav">
                  <div CLASS="nav-header" data-toggle="collapse" data-target="#dashboard-menu"><i CLASS="icon-dashboard"></i>图书</div>
                    <ul id="dashboard-menu" CLASS="nav nav-list collapse in">
                        <li ><a href="index.jsp">主页</a></li>
                        <li ><a href="BooksListServlet">所有图书</a></li>
                        <li class="active"><a href="add-books.jsp">添加图书</a></li>
                        <li ><a href="update-books.jsp">修改图书</a></li>
                        
                    </ul>
                <div CLASS="nav-header" data-toggle="collapse" data-target="#accounts-menu"><i CLASS="icon-briefcase"></i>管理员<span CLASS="label label-info">&nbsp;&nbsp;+&nbsp;&nbsp;</span></div>
                <ul id="accounts-menu" CLASS="nav nav-list collapse in">
                  <li ><a HREF="SysuserListSerclet">管理员列表</a></li>
                  <li ><a HREF="#">管理员公告</a></li>
                </ul>

                <div CLASS="nav-header" data-toggle="collapse" data-target="#settings-menu"><i CLASS="icon-exclamation-sign"></i>扩展页面</div>
                <ul id="settings-menu" CLASS="nav nav-list collapse in">
                  <li ><a HREF="#">扩展页面</a></li>
                  <li ><a HREF="#">扩展页面</a></li>
                  <li ><a HREF="#">扩展页面</a></li>
                  <li ><a HREF="#">扩展页面</a></li>
                </ul>

                <div CLASS="nav-header" data-toggle="collapse" data-target="#legal-menu"><i CLASS="icon-legal"></i>扩展工具</div>
                <ul id="legal-menu" CLASS="nav nav-list collapse in">
                  <li ><a HREF="#">扩展工具</a></li>
                  <li ><a HREF="#">扩展工具</a></li>
                </ul>
            </div>
        </div>
        <div CLASS="span9">
            <h1 CLASS="page-title">添加图书</h1>

<div CLASS="well">
    <ul CLASS="nav nav-tabs">
      <li CLASS="active"><a HREF="#home" data-toggle="tab">Profile</a></li>
      <li><a HREF="#profile" data-toggle="tab">Password</a></li>
    </ul>
    <div id="myTabContent" CLASS="tab-content">
      <div CLASS="tab-pane active in" id="home">
      <!--Form表单开始-->
    <form action="AddBooksServlet" method="post">
        <label>ISBN</label>
        <input TYPE="text"  CLASS="input-xlarge" name="isbn">
        <label>书名</label>
        <input TYPE="text"  CLASS="input-xlarge" name="title">
        <label>价格</label>
        <input TYPE="text"  CLASS="input-xlarge"  name="price">
        <label>更新时间&nbsp;&nbsp;&nbsp;</label>
        <input TYPE="text"  CLASS="input-xlarge" name="pubDt" value="时间系统自动生成" readonly>
         <label>出版社</label>
        <input TYPE="text" CLASS="input-xlarge" name="publisherName"><br>
		<div CLASS="btn-toolbar">
	    	<input type="submit" CLASS="btn btn-primary" value="Save"/>
	   		<a HREF="#myModal" data-toggle="modal" CLASS="btn">Cancel</a>
	</div>
    </form>
    <!--Form表单结束-->
      </div>
      <div CLASS="tab-pane fade" id="profile">
    <form id="tab2">
        <label>New Password</label>
        <input TYPE="password" CLASS="input-xlarge">
        <div>
            <button CLASS="btn btn-primary">Update</button>
        </div>
    </form>
      </div>
  </div>

</div>

<div CLASS="modal small hide fade" id="myModal" TABINDEX="-1" ROLE="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div CLASS="modal-header">
    <button TYPE="button" CLASS="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">Delete Confirmation</h3>
  </div>
  <div CLASS="modal-body">
    
    <p CLASS="error-text"><i CLASS="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
  </div>
  <div CLASS="modal-footer">
    <button CLASS="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
    <button CLASS="btn btn-danger" data-dismiss="modal">Delete</button>
  </div>
</div>

        </div>
    </div>
    

    
    <footer>
        <hr>
        
        <p CLASS="pull-right">Collect from <a HREF="http://www.17sucai.com/" title="网页模板" TARGET="_blank">网页模板</a></p>
        
        
        <p>&copy; 2012 <a HREF="#">Portnine</a></p>
    </footer>
    

    

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script SRC="lib/bootstrap/js/bootstrap.js"></script>
    
    
    
    
    
    
    
    
    
    
    
    

  </body>
</html>


