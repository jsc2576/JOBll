
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Pagination - Active State</h2>
  <p>Add class .active to let the user know which page he/she is on:</p>

	<ul class="pagination">
		<li class="previous"><a href="#">First</a></li>
		<li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li class="active"><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
    	<li class="next"><a href="#">Last</a></li>
  	</ul>
</div>

</body>
</html>