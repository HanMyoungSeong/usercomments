(function($, app) {
	var Commenter = function() {
	}

	Commenter.prototype = {
		call : function(callback) {
			$.ajax({
				url : app.URL,
				type : "POST",
				success : callback
			});
		}
	};

	app.Commenter = Commenter;

}(jQuery, commentSystem));