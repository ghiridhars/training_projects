$(document).ready(function () {
    $("#form1").validate({
        rules: {
            name: {
                required: true,
                minlength: 5
            },
            designation: {
                required: true
            },
            salary: {
                required: true,
                minlength:20000,
            },
           gender : {
                required: true,
            },
            'hobbies[]': {
                required: true,
                minlength:2
            },
        },
        messages: {
            name: {
                required: "Please enter Employee Full Name",
                minlength: "Name should be 5 atleast characters long"
            },
            designation: {
                required: "Please provide a valid designation",
            },
            salary:{
                required: "Please enter employee salary",
                min :"Please enter valid salary value",
            },
            gender:{
                required: "Please enter Gender",
            },
            'hobbies[]':{
                required: "Please enter hobby",
				minlength : 'Min 2 boxes'
            }

        },
        submitHandler: function (form) {
            form.submit();
			alert("Success");
			return true;
        }
    });

});