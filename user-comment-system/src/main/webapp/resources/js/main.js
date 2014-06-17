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
				var day = date.getDate()+"";
				var today = date.getFullYear() + "." + app.addZero(month) + "." + app.addZero(day);
				if(today === data[i].date){
					data[i].date = data[i].time;
				}
			}
		},
	};
	window.main = new Main();
}(jQuery, commentSystem));