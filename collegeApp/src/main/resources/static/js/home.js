$(document).ready(function() {

	$("#title1").mouseenter(function() {
		$("#content1").slideDown("slow");
		$("#content2").slideDown("slow");
	});

	$("#title1").mouseleave(function() {
		$("#content1").slideUp("slow");
		$("#content2").slideUp("slow");
	});

	$("#title3").mouseenter(function() {
		$("#content3").slideDown("slow");
		$("#content4").slideDown("slow");

	});
	$("#title3").mouseleave(function() {
		$("#content3").slideUp("slow");
		$("#content4").slideUp("slow");

	});

});