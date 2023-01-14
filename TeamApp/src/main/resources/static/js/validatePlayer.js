$(document).ready(function() {
	$("#playerForm").validate({
		rules: {
			playerName: {
				required: true,
				minlength: 5
			},
			age: {
				required: true,
				min: 16,
				max: 44
			},
			type: {
				required: true,
				minlength: 1,
			},
			teamId: {
				required: true,
			},
		},
		messages: {
			playerName: {
				required: 'Please enter name',
				minlength: 'Please enter atleast 5 characters'
			},
			age: {
				required: 'Please enter Player age',
				min: 'Minimum age is 16',
				max: 'Maximum age is 44'
			},
			type: {
				required: 'Please enter the type of player',
				minlength: 'Atleast 1 value'
			},
		},
		submitHandler: function(form) {
			form.submit();
			alert("Success");
			return true;
		}
	});
});
/**
 *
 */