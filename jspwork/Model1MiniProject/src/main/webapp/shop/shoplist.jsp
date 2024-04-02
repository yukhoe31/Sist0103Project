<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
img.photo {
	height: 100%;
	margin-bottom: 10px;
}

.shoptable {
	padding: 10px;
	
}

a.goDetail {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: underline;
	color: gray;
}
</style>
<script type="text/javascript">
  $(function(){
	  
	  
	  $("a.goDetail").click(function(){
		  var shopnum=$(this).attr("shopnum");
		  //alert(shopnum);
		  
		  //디테일 페이지로 이동
		  location.href="index.jsp?main=shop/detailpage.jsp?shopnum="+shopnum;
	  })
  });

</script>
</head>
<%
  ShopDao dao=new ShopDao();
  List<ShopDto> list=dao.getAllSangpums();
  NumberFormat nf=NumberFormat.getCurrencyInstance();
%>
<body>
	<div class="container mt-3">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				data-bs-toggle="tab" href="#tabs-total">전체</a></li>
			<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
				href="#tabs-outer">인형</a></li>
			<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
				href="#tabs-top">의상</a></li>
			<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
				href="#tabs-bottom">생활용품</a></li>
			<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
				href="#tabs-acc">악세사리</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div id="tabs-total" class="container tab-pane active">
				<br>
				<h3>전체</h3>
				<p>
				<table class="shoptable table table-bordered" style="width: 500px;">
					<tr>
						<%
                 int i=0;
                for(ShopDto dto: list)
                {
                	//20~50까지 난수발생
                	int sale=(int)(Math.random()*31)+20;
                	%>
						<td><a shopnum="<%=dto.getShopnum()%>"
							style="cursor: pointer;" class="goDetail"> <img alt=""
								src="shopsave/<%=dto.getPhoto()%>" class="photo"> <br>
								<%=dto.getSangpum() %><br></a> <b style="color: red;"><%=sale %>%</b>
							<span style="float: right;">
								<div style="color: gray; font-size: 12px;">
									<%
                	            int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
                	          %>
									<strike><%=nf.format(price) %></strike>
								</div>
								<div style="color: black;">
									<%=nf.format(dto.getPrice()) %>
								</div>
						</span></td>

						<%
                	  if((i+1)%3==0)
                	  {%>
					</tr>
					<tr>
						<%}
                	
                	 i++;
                	%>
						<%}
              %>
					</tr>

				</table>

				</p>
			</div>




			<div id="tabs-outer" class="container tab-pane fade">
				<br>
				<h3>인형</h3>
				<p>
				<table class="shoptable table table-bordered" style="width: 500px;">
					<tr>
						<%
                  i=0;
                for(ShopDto dto: list)
                {
                	
                	if(dto.getCategory().equals("인형")){
                	//20~50까지 난수발생
                	int sale=(int)(Math.random()*31)+20;
                	%>
						<td><a shopnum="<%=dto.getShopnum()%>"
							style="cursor: pointer;" class="goDetail"> <img alt=""
								src="shopsave/<%=dto.getPhoto()%>" class="photo"> <br>
								<%=dto.getSangpum() %><br></a> <b style="color: red;"><%=sale %>%</b>
							<span style="float: right;">
								<div style="color: gray; font-size: 12px;">
									<%
                	            int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
                	          %>
									<strike><%=nf.format(price) %></strike>
								</div>
								<div style="color: black;">
									<%=nf.format(dto.getPrice()) %>
								</div>
						</span></td>

						<%
                	  if((i+1)%3==0)
                	  {%>
					</tr>
					<tr>
						<%}
                	
                	 i++;
                	 
                	}
                	%>

						<%}
              %>
					</tr>

				</table>

				</p>
			</div>
			<div id="tabs-top" class="container tab-pane fade">
				<br>
				<h3>의상</h3>
				<p>
				<table class="shoptable table table-bordered" style="width: 500px;">
					<tr>
						<%
                  i=0;
                for(ShopDto dto: list)
                {
                	
                	if(dto.getCategory().equals("의상")){
                	//20~50까지 난수발생
                	int sale=(int)(Math.random()*31)+20;
                	%>
						<td><a shopnum="<%=dto.getShopnum()%>"
							style="cursor: pointer;" class="goDetail"> <img alt=""
								src="shopsave/<%=dto.getPhoto()%>" class="photo"> <br>
								<%=dto.getSangpum() %>
						</a><br> <b style="color: red;"><%=sale %>%</b> <span
							style="float: right;">
								<div style="color: gray; font-size: 12px;">
									<%
                	            int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
                	          %>
									<strike><%=nf.format(price) %></strike>
								</div>
								<div style="color: black;">
									<%=nf.format(dto.getPrice()) %>
								</div>
						</span></td>

						<%
                	  if((i+1)%3==0)
                	  {%>
					</tr>
					<tr>
						<%}
                	
                	 i++;
                	 
                	}
                	%>

						<%}
              %>
					</tr>

				</table>
				</p>
			</div>


			<div id="tabs-bottom" class="container tab-pane fade">
				<br>
				<h3>생활용품</h3>
				<p>
				<table class="shoptable table table-bordered" style="width: 500px;">
					<tr>
						<%
                  i=0;
                for(ShopDto dto: list)
                {
                	
                	if(dto.getCategory().equals("생활용품")){
                	//20~50까지 난수발생
                	int sale=(int)(Math.random()*31)+20;
                	%>
						<td><a shopnum="<%=dto.getShopnum()%>"
							style="cursor: pointer;" class="goDetail"> <img alt=""
								src="shopsave/<%=dto.getPhoto()%>" class="photo"> <br>
								<%=dto.getSangpum() %></a><br> <b style="color: red;"><%=sale %>%</b>
							<span style="float: right;">
								<div style="color: gray; font-size: 12px;">
									<%
                	            int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
                	          %>
									<strike><%=nf.format(price) %></strike>
								</div>
								<div style="color: black;">
									<%=nf.format(dto.getPrice()) %>
								</div>
						</span></td>

						<%
                	  if((i+1)%3==0)
                	  {%>
					</tr>
					<tr>
						<%}
                	
                	 i++;
                	 
                	}
                	%>

						<%}
              %>
					</tr>

				</table>

				</p>
			</div>




			<div id="tabs-acc" class="container tab-pane fade">
				<br>
				<h3>악세사리</h3>
				<p>
				<table class="shoptable table table-bordered" style="width: 500px;">
					<tr>
						<%
                  i=0;
                for(ShopDto dto: list)
                {
                	
                	if(dto.getCategory().equals("악세사리")){
                	//20~50까지 난수발생
                	int sale=(int)(Math.random()*31)+20;
                	%>
						<td><a shopnum="<%=dto.getShopnum()%>"
							style="cursor: pointer;" class="goDetail"> <img alt=""
								src="shopsave/<%=dto.getPhoto()%>" class="photo"> <br>
								<%=dto.getSangpum() %></a><br> <b style="color: red;"><%=sale %>%</b>
							<span style="float: right;">
								<div style="color: gray; font-size: 12px;">
									<%
                	            int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
                	          %>
									<strike><%=nf.format(price) %></strike>
								</div>
								<div style="color: black;">
									<%=nf.format(dto.getPrice()) %>
								</div>
						</span></td>

						<%
                	  if((i+1)%3==0)
                	  {%>
					</tr>
					<tr>
						<%}
                	
                	 i++;
                	 
                	}
                	%>

						<%}
              %>
					</tr>

				</table>

				</p>
			</div>

		</div>
	</div>
</body>
</html>