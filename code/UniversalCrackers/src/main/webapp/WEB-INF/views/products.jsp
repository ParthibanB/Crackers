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
				<input type="number" class="quantityBox" name="quantity" value="1" min="1">
				<input type="hidden" class="productPrice" value="${product.unitPrice}" />
				<input type="hidden" class="productImg" value="resources/img/comingSoon.jpg" />
				<input type="hidden" class="productName" value="${product.name}" />
				<a class="add_to_cart_button" data-quantity="1" data-product_sku=""
					data-product_id="${product.id}" rel="nofollow">Add to cart</a>
			</div>
		</div>
	</div>
</c:forEach>
<script>
	$('.add_to_cart_button').on('click',function(){
		var parent = $(this).parent();
		addToCart($(this).attr('data-product_id'),Number($(parent).find('.quantityBox').val()),Number($(parent)
				.find('.productPrice').val()),$(parent).find('.productImg').val(),$(parent).find('.productName').val());
	});
</script>