$(document).ready(function() {
	$('.tree-view.tree-view-root > a').click(
		function(event) {
			event.preventDefault();
			$(this).next('.tree-view-menu').slideToggle(200);
			$(this).parent().siblings().find('.tree-view-menu')
				.slideUp(200);
			$(this).find('.toggle-rotate').toggleClass(
				'toggle-rotate--active');
			$(this).parent().siblings().find('.toggle-rotate')
				.removeClass('toggle-rotate--active');
		});

	$('#sidebar_toggle').click(function() {
		$('body').toggleClass('sidebar-hidden');
		console.log(111);
	});
});

