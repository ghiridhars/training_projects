$(document).ready(function() {
	$("#teamForm").validate({
		rules: {
			teamName: {
				required: true,
				minlength: 2
			},
			maxLimit: {
				required: true,
				min:11,
				max:14
			},
		},
		messages: {
			teamName: {
				required: 'Please enter name',
				minlength: 'Please enter atleast 2 characters'
			},
			maxLimit: {
				required: 'Please enter limit of players ina team',
				min:'Minimum squad length is 11',
				max:'Maximum squad length is 14'
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