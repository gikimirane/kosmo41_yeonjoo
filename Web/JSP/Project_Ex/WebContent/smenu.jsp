<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>슬라이드 메뉴</title>
		<style> 
			.head {
				cursor: pointer;
			}
		</style>
		<script src='<c:out value="${contextPath}"/>/res/js/date/jquery-1.10.2.js'></script>
			<script>
		
				$(document).ready(function(){
					$('#menu ul').hide();
					$('#menu h1.head').click(function(){
						var checkElement = $(this).next();
						if(!checkElement.is(':visible')) {
							alert("test");
							$('#menu ul.sub:visible').slideUp(300);
							checkElement.slideDown(300);
							return false;
						}
					});
				});	
			</script>
	
		</head>
	<body>

 		<div>
        <ul id="menu">

             <li>
                       <h1 class="head">메인 메뉴1</h1>
                        <ul class="sub">

                                <li>메뉴1</li>

                                <li>메뉴2</li>

                                <li>메뉴3</li>

                                <li>메뉴4</li>

                                <li>메뉴5</li>

                        </ul>

                </li>

                <li>

                        <h1 class="head">메인 메뉴2</h1>
                        <ul class="sub">

                                <li>메뉴1</li>

                                <li>메뉴2</li>

                                <li>메뉴3</li>

                                <li>메뉴4</li>

                                <li>메뉴5</li>

                        </ul>

                </li>

        </ul>

	</div>

</body>

</html>
