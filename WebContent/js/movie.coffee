$ ->
	$('.carousel').carousel(
		interval: 2000
	)
	$('#videoDiv').hide()
	
	$('.play').bind('click', =>
		alert @.attr 'vpath'
	)
	
	
