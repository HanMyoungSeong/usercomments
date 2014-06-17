var commentSystem = {};
(function(app) {
	app.URL = "http://localhost:8080/jejuuniv/comment.json";
	app.addZero = function(data) {
		if (data.length === 2) {
			return data;
		} else {
			return "0" + data;
		}
	};
}(commentSystem));
