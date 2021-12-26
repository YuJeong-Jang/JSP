let replyService = (function() {
	function add(callback, error) {
		//등록
		$.ajax({
			url: "../reply/",
			data: $('#replyForm').serialize(),
			method: "post",
			dataType: "json",
			success: function(data) {
				if (callback) callback(data);
			},
			error: function() {
				if (error) error();
			}
		});
	}
	//목록
	function getList(param, callback, error) {
		$.ajax({
			url: "../reply/",
			data: param,
			dataType: "json",
			success: function(data) {
				if (callback) callback(data);
			},
			error: function() {
				if (error) error();
			}
		});
	}
	return { add: add, getList:getList  }
})();