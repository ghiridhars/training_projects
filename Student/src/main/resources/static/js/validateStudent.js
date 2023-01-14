$(document).ready(function() {
	$("#studentForm").validate({
		rules: {
			name: {
				required: true,
				minlength: 5
			},
			gender: {
				required: true
			},
			subjects: {
				required: true,
				minlength: 1,
			},
			className: {
				required: true,
				minlength: 3
			}

		},
		messages: {
			name: {
				required: 'Please enter name',
				minlength: 'Please enter name with 5 characters'
			},
			gender: {
				required: 'Please enter gender'
			},
			subjects: {
				required: 'Please enter subjects',
				minlength: 'Please enter atleast 1 value',

			},
			className: {
				required: 'Please enter class Name',
				minlength: 'Minimum 3 characters'
			}


		},
		submitHandler: function(form) {
			form.submit();
			return true;
		}
	});
});
