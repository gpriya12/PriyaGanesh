$(document).ready(
		function() {
			$.ajax({
				type : "GET",
				url : "http://api.github.com/users",
				dataType : "json",
				success : function(data) {

					var trHTML = '';
					$.each(data, function(i, item) {
						trHTML += '<tr><td>' + data[i].login + '</td><td>'
								+ data[i].id + '</td><td>' + data[i].site_admin
								+ '</td><td><a href=' + data[i].avatar_url
								+ '> Picture </a></td><td>'
								+ '<button class="btn btn-success" id='
								+ data[i].login + '>Click</button>'
								+ '</td></tr>';
					})
					$("#tb01").append(trHTML);

				},
				error : function(msg) {
					alert(msg.responseText);
				}
			});

			$(document).on("click", "#tb01 button.btn", function(data) {

				var username = '';
				var target = data.target
				username = target.id;

				$.ajax({
					type : "GET",
					url : "https://api.github.com/users/" + username,
					dataType : "json",
					success : function(data) {
						var trFollowers = data.followers;
						target.innerText = trFollowers;
					}
				})

			});

		})