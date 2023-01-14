$(document).ready(function () {
    $("#collegeForm").validate({
        rules: {
            collegeName: {
                required: true,
                minlength: 5
            },
            strength: {
                required: true,
				min:3,
				max:2000
            },
        },
        messages: {
            collegeName: {
                required: "Please enter College Name",
                minlength: "Name should be 5 atleast characters long"
            },
            strength:{
                required: "Please enter College Strength"
            },
        },
        submitHandler: function (form) {
            form.submit();
			alert("Submitted");
			return true;
        }
    });
});/**
 * 
 */