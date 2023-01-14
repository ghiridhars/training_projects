$(document).ready(function() {
	$("#stateForm").validate({
		rules: {
			stateName: {
				required: true,
				minlength: 3
			},
			population: {
				required: true,
				min: 500000
			},
			capital: {
				required: true,
				minlength: 3
			},
			countryName: {
				required: true,
			},
		},
		messages: {
			name: {
				required: "Please enter State Name",
				minlength: "Name should be 3 atleast characters long"
			},
			population: {
				required: "Please enter population",
				min: "Please enter valid value"
			},
			capital: {
				required: "Please enter capital",
				minlength: "Name should be 3 atleast characters long"
			},
			countryName: {
				required: "Please select country name",
			},

		},
		submitHandler: function(form) {
			form.submit();
			alert("Success");
			return true;
		}
	});
});