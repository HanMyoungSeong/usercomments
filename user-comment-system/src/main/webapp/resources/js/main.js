(function($, app) {
	var Main = function() {
		this.commenter = new app.Commenter();
		this.run();
	}

	Main.prototype = {
		run : function() {
			this.commenter.call(this.print.bind(this));
		},

		print : function(data) {
			var listTemplate = $("#listTemplate").html();
			_.templateSettings = {
				interpolate : /\<\@\=(.+?)\@\>/gim,
				evaluate : /\<\@([\s\S]+?)\@\>/gim,
				escape : /\<\@\-(.+?)\@\>/gim
			};
			$("#content")["append"](_.template(listTemplate, {
				list : data
			}));
		}
	};
	window.main = new Main();
}(jQuery, commentSystem));