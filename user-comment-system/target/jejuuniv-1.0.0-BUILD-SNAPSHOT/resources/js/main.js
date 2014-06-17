(function($, app) {
	function Main() {
		this.commenter = new app.Commenter();
		this.run();
	}

	Main.prototype = {
		run : function() {
			this.commenter.call(this.print.bind(this));
		},

		print : function(data) {
			this.makeCurrentTime(data);
			
			_.templateSettings = {
				interpolate : /\<\@\=(.+?)\@\>/gim,
				evaluate : /\<\@([\s\S]+?)\@\>/gim,
				escape : /\<\@\-(.+?)\@\>/gim
			};

			var listTemplate = $("#listTemplate").html();
			$("#content")["append"](_.template(listTemplate, {
				list : data
			}));
		},

		makeCurrentTime : function(data) {
			for (var i = 0; i < data.length; i++) {
				var date = new Date();
				var month = (date.getMonth() + 1);
				var today = date.getFullYear() + "." + app.addZero(month) + "." + date.getDate();

				var hour = date.getHours() ;
				var minute = date.getMinutes();
				if (data[i].date == today) {
						data[i].date = hour+":"+app.addZero(minute);	
				}
			}
		},
	};
	window.main = new Main();
}(jQuery, commentSystem));