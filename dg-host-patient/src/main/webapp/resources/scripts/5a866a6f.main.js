$(function() {
	$(".user-info").on(
			"mouseenter",
			function(a) {
				a.preventDefault(), $(this).parents(".user-menu").find(
						"ul:first").slideDown().addClass("active")
			}), $(".user-info").on("mouseleave", function() {
		$(this).parents(".user-menu").find("ul:first").slideUp()
	}), $(".fig-block").on("click", "button", function() {
		$(".overlay-bg").slideDown("fast", function() {
			$(window).scrollTop(0), $(".overlay").fadeIn("fast")
		})
	}), $(".overlay").on("click", ".ico-close", function() {
		$(".overlay-bg, .overlay").hide()
	})
});