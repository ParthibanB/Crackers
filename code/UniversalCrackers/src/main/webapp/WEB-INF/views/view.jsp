<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Universal Crackers - Shop</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="resources/css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="resources/css/owl.carousel.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/responsive.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


	<div class="site-branding-area navbar-fixed-top">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="logo">
						<img src="resources/img/logo.png" style="position: relative; top: -10px;"
						onclick="javascript:backToHome()">
					</div>
				</div>

				<div class="col-md-6">
					<div class="col-md-8 headerSearch text-center">
						<form action="#">
							<input type="text" value="" placeholder="Search...">
							<button class="my-btn">
								<i class="fa fa-search"></i>
							</button>
						</form>
					</div>
					<div class="col-md-4 shopping-item">
						<a href="javascript:void(0)">Cart - <span class="cart-amunt">$100</span>
							<i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->




	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<div class="widget widget-categories">
						<h3 class="sidebarTitle">Categories</h3>
						<ul class="sidebar-menu">
							<c:forEach var="category" items="${categories}" varStatus="loop">
								<li><input type="checkbox" id="${category.id}" ${loop.first?'checked':'' }/>
								 <span class="menuName">${category.name}</span>
								 <span class="count">(${category.productCount})</span></li>
							</c:forEach>
						</ul>
					</div>
					<!-- <div class="widget widget-categories">
						<h3 class="sidebarTitle">Brands</h3>
						<ul class="sidebar-menu">
							<li><input type="checkbox" /> <span class="menuName">MENU
									1</span> <span class="count">(09)</span></li>
							<li><input type="checkbox" /> <span class="menuName">MENU
									2</span> <span class="count">(33)</span></li>
							<li><input type="checkbox" /> <span class="menuName">MENU
									3</span> <span class="count">(109)</span></li>
							<li><input type="checkbox" /> <span class="menuName">MENU
									4</span> <span class="count">(11)</span></li>
							<li><input type="checkbox" /> <span class="menuName">MENU
									5</span> <span class="count">(678)</span></li>
						</ul>
					</div> -->
				</div>
				<div class="col-md-9 col-sm-6" id="productList">
				</div>
			</div>

			<!--  <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <nav>
                          <ul class="pagination">
                            <li>
                              <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                              <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                          </ul>
                        </nav>                        
                    </div>
                </div>
            </div> -->
		</div>
	</div>



	<div class="footer-top-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="footer-widget">
						<h3>CONTACT US</h3>
						<ul class="footer-contact">
							<li><i class="fa fa-map-marker"> </i> Addresss: 123 Pall
								Mall, London England</li>
							<li><i class="fa fa-envelope"> </i> Email:
								sasikcrackers@gmail.com <br></li>
							<li><i class="fa fa-phone"> </i> Phone: 09952567397 ,
								09443221933 , 09894102440 <br></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- End footer top area -->


	<!-- Latest jQuery form server -->
	<script src="https://code.jquery.com/jquery.min.js"></script>

	<!-- Bootstrap JS form CDN -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<!-- jQuery sticky menu -->
	<script src="resources/js/owl.carousel.min.js"></script>
	<script src="resources/js/jquery.sticky.js"></script>

	<!-- jQuery easing -->
	<script src="resources/js/jquery.easing.1.3.min.js"></script>

	<!-- Main Script -->
	<script src="resources/js/main.js"></script>

	<!-- Slider -->
	<script type="text/javascript" src="resources/js/bxslider.min.js"></script>
	<script type="text/javascript" src="resources/js/script.slider.js"></script>
	<script>
		$('.shopping-item').on('click',function(){
			getCartDetails();
		});
	
		function getCartDetails(){
			$.ajax({
				url : "cart",
				type : "GET",
				dataType : "html",
				success : function(response){
					$('.single-product-area .container').html(response);
				},
				error : function(xhr){
				}
			});
		}
		
		function getShippingAddressView(){
			$.ajax({
				url : "checkout",
				type : "GET",
				dataType : "html",
				success : function(response){
					$('.single-product-area .container').html(response);
				},
				error : function(xhr){
				}
			});
		}
		
		function placeOrder(){
			$.ajax({
				url : "placeOrder",
				type : "GET",
				dataType : "html",
				success : function(response){
					$('.single-product-area .container').html(response);
				},
				error : function(xhr){
				}
			});
		}
		
		function backToHome(){
			$.ajax({
				url : "backToHome",
				type : "GET",
				dataType : "html",
				success : function(response){
					$('.single-product-area .container').html(response);
				},
				error : function(xhr){
				}
			});
		}
		
		$('.widget-categories input[type=checkbox]').on('change',function(){
			getProductList();
		});
		
		getProductList();
		
		function getProductList(){
			var categories = "";
			$('.widget-categories input[type=checkbox]').each(function(){
				if($(this).is(":checked")){
					if(categories != ""){
						categories += ",";
					}
					categories += $(this).attr('id');
				}
			});
			if(categories.length > 0){
				$.ajax({
					url : "productList",
					type : "GET",
					dataType : "html",
					data : {
						"categories" : categories
					},
					success : function(response){
						$('#productList').html(response);
					},
					error : function(xhr){
					}
				});	
			}else{
				$('#productList').html("No products found for the selection.");
			}
		}
	</script>
</body>
</html>