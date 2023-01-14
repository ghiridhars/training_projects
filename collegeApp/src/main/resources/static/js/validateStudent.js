$(document).ready(function () {
    $("#studentForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 5
            },
            subject: {
                required: true
            },
            age: {
                required: true,
				min:18,
				max:35
            },
        },
        messages: {
            name: {
                required: "Please enter Student Full Name",
                minlength: "Name should be 5 atleast characters long"
            },
            subject: {
                required: "Please provide a valid subject",
            },
            age:{
                required: "Please enter student age",
            },
        },
        submitHandler: function (form) {
            form.submit();
			alert("Submitted");
			return true;
        }
    });
});