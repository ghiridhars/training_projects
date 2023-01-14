$(document).ready(function() {
	$("#personForm").validate({
		rules: {
			name: {
				required: true,
				minlength: 5
			},
			gender: {
				required: true,
			},
			'hobbies[]': {
				required: true,
				minlength: 2
			},
			countryName: {
				required: true,
			},
			stateName: {
				required: true,
			}
		},
		messages: {
			name: {
				required: "Please enter Person Full Name",
				minlength: "Name should be 5 atleast characters long"
			},
			gender: {
				required: "Please enter Gender",
			},
			'hobbies[]': {
				required: "Please enter hobby",
				minlength: "Please select atleast 2 hobby"
			},
			countryName: {
				required: "Please select country"
			},
			stateName: {
				required: "Please select state"
			}

		},
		submitHandler: function(form) {
			form.submit();
			alert("Success");
			return true;
		}
	});

});