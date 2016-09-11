<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">

	<div class="col-md-12">
		<div class="product-content-right">
			<div class="woocommerce">


				<form enctype="multipart/form-data" action="javascript:void(0)" class="checkout"
					method="post" name="checkout">

					<div id="customer_details" class="col-md-8">

						<div class="">
							<div class="woocommerce-shipping-fields">
								<h3>Shipping Information</h3>

								<div class="shipping_address" style="display: block;">


									<p id="shipping_first_name_field"
										class="form-row form-row-first validate-required col-md-6">
										<label class="" for="shipping_first_name">First Name <abbr
											title="required" class="required">*</abbr>
										</label> <input type="text" value="" placeholder=""
											id="shipping_first_name" name="shipping_first_name"
											class="input-text ">
									</p>

									<p id="shipping_last_name_field"
										class="form-row form-row-last validate-required col-md-6">
										<label class="" for="shipping_last_name">Last Name <abbr
											title="required" class="required">*</abbr>
										</label> <input type="text" value="" placeholder=""
											id="shipping_last_name" name="shipping_last_name"
											class="input-text ">
									</p>
									<div class="clear"></div>

									<p id="billing_email_field"
										class="form-row form-row-first validate-required validate-email col-md-6">
										<label class="" for="billing_email">Email Address <abbr
											title="required" class="required">*</abbr>
										</label> <input type="text" value="" placeholder="" id="billing_email"
											name="billing_email" class="input-text ">
									</p>

									<p id="billing_phone_field"
										class="form-row form-row-last validate-required validate-phone col-md-6">
										<label class="" for="billing_phone">Phone <abbr
											title="required" class="required">*</abbr>
										</label> <input type="text" value="" placeholder="" id="billing_phone"
											name="billing_phone" class="input-text ">
									</p>

									<p id="shipping_address_1_field"
										class="form-row form-row-wide address-field validate-required col-md-6">
										<label class="" for="shipping_address_1">Address 1 <abbr
											title="required" class="required">*</abbr>
										</label> <input type="text" value="" placeholder="Street address"
											id="shipping_address_1" name="shipping_address_1"
											class="input-text ">
									</p>

									<p id="shipping_address_2_field"
										class="form-row form-row-wide address-field col-md-6">
										<label class="" for="shipping_address_1">Address 1 <abbr
											title="required" class="required">*</abbr>
										</label> <input type="text" value=""
											placeholder="Apartment, suite, unit etc. (optional)"
											id="shipping_address_2" name="shipping_address_2"
											class="input-text ">
									</p>

									<p id="shipping_city_field"
										class="form-row form-row-wide address-field validate-required col-md-6"
										data-o_class="form-row form-row-wide address-field validate-required">
										<label class="" for="shipping_city">Town / City <abbr
											title="required" class="required">*</abbr>
										</label> <input type="text" value="" placeholder="Town / City"
											id="shipping_city" name="shipping_city" class="input-text ">
									</p>

									<p id="shipping_state_field"
										class="form-row form-row-first address-field validate-state col-md-6"
										data-o_class="form-row form-row-first address-field validate-state">
										<label class="" for="shipping_state">County</label> <input
											type="text" id="shipping_state" name="shipping_state"
											placeholder="State / County" value="" class="input-text ">
									</p>
									<p id="shipping_postcode_field"
										class="form-row form-row-last address-field validate-required validate-postcode col-md-6"
										data-o_class="form-row form-row-last address-field validate-required validate-postcode">
										<label class="" for="shipping_postcode">Postcode <abbr
											title="required" class="required">*</abbr>
										</label> <input type="text" value="" placeholder="Postcode / Zip"
											id="shipping_postcode" name="shipping_postcode"
											class="input-text ">
									</p>

									<div class="clear"></div>


								</div>

							</div>

						</div>

					</div>



					<div id="order_review" style="position: relative;" class="col-md-4">
						<h3 id="order_review_heading">Your order</h3>
						<table class="shop_table">
							<thead>
								<tr>
									<th class="product-name">Product</th>
									<th class="product-total">Total (in &#x20a8;)</th>
								</tr>
							</thead>
							<c:set var="total" value="0" />
							<tbody>
								<c:forEach var="cartItem" items="${cartItems}">
									<tr class="cart_item">
										<td class="product-name">${cartItem.name}
										</td>
										<td class="product-total"><span class="amount">${cartItem.qty} X ${cartItem.unitPrice}</span>
										<c:set var="total" value="${total + cartItem.unitPrice}" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>

								<tr class="cart-subtotal">
									<th>Cart Subtotal</th>
									<td><span class="amount">&#x20a8; ${total}</span></td>
								</tr>

								<tr class="shipping">
									<th>Shipping and Handling</th>
									<td>Free Shipping <input type="hidden"
										class="shipping_method" value="free_shipping"
										id="shipping_method_0" data-index="0"
										name="shipping_method[0]">
									</td>
								</tr>


								<tr class="order-total">
									<th>Order Total</th>
									<td><strong><span class="amount">&#x20a8; ${total}</span></strong></td>
								</tr>

							</tfoot>
						</table>
						<div id="payment" class="col-md-12">
							<ul class="payment_methods methods">
								<li class="payment_method_bacs"><input type="radio"
									data-order_button_text="" checked="checked" value="bacs"
									name="payment_method" class="input-radio"
									id="payment_method_bacs"> <label
									for="payment_method_bacs">Direct Bank Transfer </label>
									<div class="payment_box payment_method_bacs">
										<p>Make your payment directly into our bank account.
											Please use your ORDER REFERENCE NO as the payment reference.
											Your order won’t be shipped until the funds have cleared in
											our account.</p>
									</div></li>
							</ul>
							<div class="form-row place-order col-md-6">

								<input type="submit" value="back to Shop" id="continue_shopping"
									class="button alt">


							</div>
							<div class="form-row place-order col-md-6 pull-right">

								<input type="submit" data-value="Place order"
									value="Place order" id="place_order"
									name="woocommerce_checkout_place_order" class="button alt">


							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>
<script>
	$('#place_order').on('click',function(){
		placeOrder();
	});
	
	$('#continue_shopping').on('click',function(){
		backToHome();
	});
</script>