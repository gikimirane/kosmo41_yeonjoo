<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>19 ex 사이트</title>		
	<style>		
			#content dd { 
				float:left; width:400px; height:200px; 
			}
			
			#mask { 
				float:left; overflow:hidden; width:400px; height:200px; 
			}
			
			#prevbtn { 
				float:left; cursor:pointer; position:relative; top:90px; width:14px; height:28px; padding-right:20px; 
			}
			
			#nextbtn { 
			float:left; cursor:pointer; position:relative; top:90px; width:14px; height:28px; padding-left:20px; 
			}
			
		</style>
			<script type="text/javascript" src="js/jquery.min.js"></script>
	
		<script type="text/javascript">

			  var divWidth  = "400"; //배너 1개 가로크기
			  //이전
			  function prev()
			  {
			   $("#content").stop(true,true);
			
			   var moveX   = parseInt($("#content").css("margin-left"));
			
			   if( moveX < 0 )
			   {
			    $("#content").animate({"margin-left":"+=" + divWidth + "px"},500);
			   }
			   else
			   {
			    alert("처음 입니다.");
			    return;
			   }
			  }
			
			  //다음
			  function next()
			  {
			   $("#content").stop(true,true);
			
			   var hiddenWidth  = ($("#content dd").length-1)*(-divWidth);
			   var moveX   = parseInt($("#content").css("margin-left")) ;
			   var lastWidth  = ( moveX - divWidth );
			
			   if( hiddenWidth < moveX )
			   {
			    $("#content").animate({"margin-left":"-=" + divWidth + "px"},500);
			   }
			   else
			   {
			    alert("마지막 입니다.");
			    return;
			   }
			  }
 			</script>
		</head>
		
	<body>
	
			<div id="warp">
  				<div id="mask">
		   			<div id="content">
		    	<dl>
		    	 <dt>
			      <dd><img src="img/kakao01.jpg"></dd>
			      <dd><img src="img/kakao02.jpg"></dd>
			      <dd><img src="img/kakao03.jpg"></dd>
			      <dd><img src="img/kakao04.jpg"></dd>
			      <dd><img src="img/kakao05.jpg"></dd>
		     	</dt>
		    	</dl>
		   </div>
		  </div>
		 </div>	
		 
		<div id="prevbtn" onclick="prev()"><img src="img/shinhwa.gif" ></div>
		<div id="nextbtn" onclick="next()"><img src="img/kakao1.gif"></div>

	</div>
		
	</body>
</html>
