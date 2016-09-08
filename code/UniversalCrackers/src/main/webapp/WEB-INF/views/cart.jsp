<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<c:set var="orderTotal" value="0" />
	<div class="col-md-12">
		<div class="product-content-right">
			<div class="woocommerce">
				<form method="post" action="javascript:void(0)">
					<table cellspacing="0" class="shop_table cart">
						<thead>
							<tr>

								<th class="product-thumbnail">&nbsp;</th>
								<th class="product-name">Product</th>
								<th class="product-price">Price</th>
								<th class="product-quantity">Quantity</th>
								<th class="product-subtotal">Total</th>
								<th class="product-remove">&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cartItem" items="${cartItems}">
								<tr class="cart_item" id="${cartItem.id}">
									<input type="hidden" class="productPrice" value="${cartItem.unitPrice}" />
									<input type="hidden" class="productImg" value="${cartItem.imgUrl}" />
									<input type="hidden" class="productName" value="${cartItem.name}" />
									<td class="product-thumbnail"><a
										href="single-product.html"><img width="145" height="145"
											alt="poster_1_up" class="shop_thumbnail"
											src="${cartItem.imgUrl}"></a></td>

									<td class="product-name"><a href="single-product.html">${cartItem.name }</a></td>

									<td class="product-price"><span class="amount">&#x20a8;
											${cartItem.unitPrice }</span></td>

									<td class="product-quantity">
										<div class="quantity buttons_added">
											<input type="number" size="4" class="input-text qty text"
												title="Qty" value="${cartItem.qty}" min="1" step="1">

										</div>
									</td>
									<c:set var="orderTotal" value="${orderTotal+(cartItem.qty * cartItem.unitPrice) }" />
									<td class="product-subtotal"><span class="amount">&#x20a8;
											${cartItem.qty * cartItem.unitPrice}</span></td>
									<td class="product-remove" ><a title="Remove this item"
										class="remove" href="javascript:void(0)">×</a></td>
								</tr>
							</c:forEach>

							<tr>
								<td class="actions" colspan="6">
									<div class="coupon">
										<label for="coupon_code">Coupon:</label> <input type="text"
											placeholder="Coupon code" value="" id="coupon_code"
											class="input-text" name="coupon_code"> <input
											type="submit" value="Apply Coupon" name="apply_coupon"
											class="button">
									</div> <input type="submit" value="Continue Shopping"
									name="update_cart" class="button" id="continue_shopping">
									<input type="submit" value="Checkout" name="proceed"
									id="checkout" class="checkout-button button alt wc-forward">
								</td>
							</tr>

						</tbody>
					</table>
				</form>

				<div class="cart-collaterals">





					<div class="cart_totals ">
						<h2>Cart Totals</h2>

						<table cellspacing="0">
							<tbody>
								<tr class="cart-subtotal">
									<th>Cart Subtotal</th>
									<td>&#x20a8; <span class="amount">${orderTotal}</span></td>
								</tr>

								<tr class="shipping">
									<th>Shipping and Handling</th>
									<td>Free Shipping</td>
								</tr>

								<tr class="order-total">
									<th>Order Total</th>
									<td><strong>&#x20a8; <span class="amount"> ${orderTotal}</span></strong></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$('#checkout').on('click', function() {
		getShippingAddressView();
	});

	$('#continue_shopping').on('click', function() {
		backToHome();
	});
	
	$('.product-remove').on('click',function(){
		delete cartItems[$(this).parents('.cart_item').attr('id')];
		$(this).parents('.cart_item').remove();
		var totalItems = 0;
		var totalAmt = 0;
		for(var td in cartItems){
			totalItems += cartItems[td].qty;
			totalAmt += (cartItems[td].price * cartItems[td].qty);
		}
		$('.cart-amunt').html(totalAmt.toFixed(2));
		$('.product-count').html(totalItems);
		$('.cart-subtotal .amount').html(totalAmt.toFixed(2));
		$('.order-total .amount').html(totalAmt.toFixed(2));
	});
</script>