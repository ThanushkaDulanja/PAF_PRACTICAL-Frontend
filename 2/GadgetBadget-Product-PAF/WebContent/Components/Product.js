//hide alert
  /*  $(document).ready(function() {

	$("#alertSuccess").hide();
	$("#alertError").hide();
	$("#productID").val("");
	$("#PRODUCT")[0].reset();
});

$(document).on("click", "#clear", function(event) {

	$("#PRODUCT")[0].reset();
	$("#alertError").hide();
});

$(document).on("click", "#save_product", function(event) {

	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	var type = ($("#productID").val() == "") ? "POST" : "PUT";

	$.ajax({
		url: "ProductAPI",
		type: type,
		data: $("#PRODUCT").serialize(),
		dataType: "text",
		complete: function(response, status) {
			onItemSaveComplete(response.responseText, status);

			$("#alertSuccess").fadeTo(2000, 500).slideUp(500, function() {
				$("#alertSuccess").slideUp(500);
			});
		}
	});

});

function onItemSaveComplete(response, status) {

	if (status == "success") {

		//console.log(response);
		var resultSet = JSON.parse(response);

		if (resultSet.status.trim() == "success") {

			$("#alertSuccess").text("Product Details Successfully saved.");
			$("#alertSuccess").show();
			$("#ProductGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {

			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}
	else if (status == "error") {

		$("#alertError").text("Error while saving.");
		$("#alertError").show();

	} else {

		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}

	$("#productID").val("");
	$("#PRODUCT")[0].reset();
}

$(document).on("click", ".btnUpdate", function(event) {
	$("#hidProductIDSave").val($(this).data("productID"));
	$("#productID").val($(this).closest("tr").find('td:eq(0)').text());
	$("#productCode").val($(this).closest("tr").find('td:eq(1)').text());
	$("#productName").val($(this).closest("tr").find('td:eq(2)').text());
	$("#productPrice").val($(this).closest("tr").find('td:eq(3)').text());
	$("#productDesc").val($(this).closest("tr").find('td:eq(4)').text());


});

$(document).on("click", ".btnRemove", function(event) {


	$.ajax({
		url: "ProductAPI",
		type: "DELETE",
		data: "productID=" + event.target.value,
		dataType: "text",
		complete: function(response, status) {
			onItemDeleteComplete(response.responseText, status);
			//window.location.reload(true);
			$("#alertSuccess").fadeTo(2000, 500).slideUp(500, function() {
				$("#alertSuccess").slideUp(500);
			});

		}
	});
});

function onItemDeleteComplete(response, status) {

	if (status == "success") {

		var resultSet = JSON.parse(response);

		if (resultSet.status.trim() == "success") {

			$("#alertSuccess").text("Product Details Successfully deleted.");
			$("#alertSuccess").show();
			$("#ProductGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {

			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}

	} else if (status == "error") {

		$("#alertError").text("Error while deleting.");
		$("#alertError").show();

	} else {

		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

function validateItemForm() {

	

	if ($("#productCode").val().trim() == "") {
		return "Enter Product code.";
	}

	if ($("#productName").val().trim() == "") {
		return "Enter Short Description.";
	}

	if ($("#productPrice").val().trim() == "") {
		return "Enter Price.";
	}

	if ($("#productDesc").val().trim() == "") {
		return "Enter Description.";
	}


	return true;
} */







//hide alert
$(document).ready(function() {

	$("#alertSuccess").hide();
	$("#alertError").hide();
	$("#productID").val("");
	$("#PRODUCT")[0].reset();
});

$(document).on("click", "#clear", function(event) {

	$("#PRODUCT")[0].reset();
	$("#alertError").hide();
});

$(document).on("click", "#save_product", function(event) {

	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	var type = ($("#productID").val() == "") ? "POST" : "PUT";

	$.ajax({
		url: "ProductAPI",
		type: type,
		data: $("#PRODUCT").serialize(),
		dataType: "text",
		complete: function(response, status) {
			onItemSaveComplete(response.responseText, status);

			$("#alertSuccess").fadeTo(2000, 500).slideUp(500, function() {
				$("#alertSuccess").slideUp(500);
			});
		}
	});

});

function onItemSaveComplete(response, status) {

	if (status == "success") {

		//console.log(response);
		var resultSet = JSON.parse(response);

		if (resultSet.status.trim() == "success") {

			$("#alertSuccess").text("Prodcut Details Successfully saved.");
			$("#alertSuccess").show();
			$("#ProductGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {

			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}
	else if (status == "error") {

		$("#alertError").text("Error while saving.");
		$("#alertError").show();

	} else {

		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}

	$("#productID").val("");
	$("#PRODUCT")[0].reset();
}

$(document).on("click", ".btnUpdate", function(event) {
	$("#hidFundIDSave").val($(this).data("productID"));
	$("#productID").val($(this).closest("tr").find('td:eq(0)').text());
	$("#productCode").val($(this).closest("tr").find('td:eq(1)').text());
	$("#productName").val($(this).closest("tr").find('td:eq(2)').text());
	$("#productPrice").val($(this).closest("tr").find('td:eq(3)').text());
	$("#productDesc").val($(this).closest("tr").find('td:eq(4)').text());
	

});

$(document).on("click", ".btnRemove", function(event) {


	$.ajax({
		url: "ProductAPI",
		type: "DELETE",
		data: "productID=" + event.target.value,
		dataType: "text",
		complete: function(response, status) {
			onItemDeleteComplete(response.responseText, status);
			//window.location.reload(true);
			$("#alertSuccess").fadeTo(2000, 500).slideUp(500, function() {
				$("#alertSuccess").slideUp(500);
			});

		}
	});
});

function onItemDeleteComplete(response, status) {

	if (status == "success") {

		var resultSet = JSON.parse(response);

		if (resultSet.status.trim() == "success") {

			$("#alertSuccess").text("product Details Successfully deleted.");
			$("#alertSuccess").show();
			$("#ProductGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {

			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}

	} else if (status == "error") {

		$("#alertError").text("Error while deleting.");
		$("#alertError").show();

	} else {

		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

function validateItemForm() {


	if ($("#productCode").val().trim() == "") {
		return "Enter code .";
	}

	if ($("#productName").val().trim() == "") {
		return "Enter Your product name.";
	}
	
	

	if ($("#productPrice").val().trim() == "") {
		return "Enter price.";
	}

	if ($("#productDesc").val().trim() == "") {
		return "Enter Product Description .";
	}

	
	return true;
}




