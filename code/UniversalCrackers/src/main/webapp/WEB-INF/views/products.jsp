<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="product" items="${products}">
	<div class="col-md-3 col-sm-6">
		<div class="single-shop-product">
			<div class="product-upper">
				<img src="resources/img/comingSoon.jpg" alt="">
			</div>
			<h2>${product.name}</h2>
			<div class="product-carousel-price">
				<ins>&#x20a8; ${product.unitPrice}</ins>
				<!-- <del>$999.00</del> -->
			</div>

			<div class="product-option-shop">
				<input type="number" class="quantityBox" name="quantity" value="1">
				<a class="add_to_cart_button" data-quantity="1" data-product_sku=""
					data-product_id="70" rel="nofollow"
					href="/canvas/shop/?add-to-cart=70">Add to cart</a>
			</div>
		</div>
	</div>
</c:forEach>