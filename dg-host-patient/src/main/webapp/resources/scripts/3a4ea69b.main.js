$(function() {
	$(".user-info").on(
			"mouseenter",
			function(a) {
				a.preventDefault(), $(this).parents(".user-menu").find(
						"ul:first").slideDown().addClass("active")
			}), $(".user-info").on("mouseleave", function() {
		$(this).parents(".user-menu").find("ul:first").slideUp()
	}), $(".fig-block").on("click", "button", function() {
		var overlay = $(this).attr("id");
		$(".overlay-bg").slideDown("fast", function() {
			$(window).scrollTop(0), $("." + overlay).fadeIn("fast")
		})
	}), $("#js-o-nav").on("click", "#js-signup", function() {
		$(".overlay-bg").slideDown("fast", function() {
			$(window).scrollTop(0), $(".js-signup-overlay").fadeIn("fast")
		})
	}), $("#js-o-nav").on("click", "#js-signin", function() {
		$(".overlay-bg").slideDown("fast", function() {
			$(window).scrollTop(0), $(".js-signin-overlay").fadeIn("fast")
		})
	}), $(".js-o-nav").on("click", ".js-signin", function() {
		$(".overlay-bg").slideDown("fast", function() {
			$(window).scrollTop(0), $(".js-signin-overlay").fadeIn("fast")
		})
	}), $("#js-o-nav").on(
			"click",
			"#js-confirmation",
			function() {
				$(".overlay-bg").slideDown(
						"fast",
						function() {
							$(window).scrollTop(0), $(
									".js-confirmation-overlay").fadeIn("fast")
						})
			}), $(".overlay").on("click", ".ico-close", function(a) {
		a.stopPropagation(), $(".overlay-bg, .overlay").hide()
	}), $(".overlay-bg").on("click", function() {
		$(".overlay").find(".ico-close").trigger("click")
	}), $(".confirmationcontent").on("click",".btn", function() {
		$(".overlay").find(".ico-close").trigger("click")
	})
});