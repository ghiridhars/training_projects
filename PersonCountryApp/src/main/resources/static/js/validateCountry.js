$(document).ready(function() {

	$("#countryForm").validate({
		rules: {
			countryName: {
				required: true,
				minlength: 5
			},
			countryType: {
				required: true,
			}
		},
		messages: {
			countryName: {
				required: "Please enter Country Name",
				minlength: "Name should be 5 atleast characters long"
			},
			countryType: {
				required: "Please enter Country Type"
			}
		},
		submitHandler: function(form) {
			form.submit();
			alert("Success");
			return true;
		}
	});

});