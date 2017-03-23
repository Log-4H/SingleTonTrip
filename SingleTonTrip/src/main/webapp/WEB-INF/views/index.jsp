<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="./module/top.jsp" />
<c:import url="./module/nav.jsp" />
	<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:50px">

	<div class="jumbotron text-center">
		<h1><span style="color:#00D8FF"><strong>잊지 못할 여행의 시작, 싱글톤트립.</strong></span><br> 집에서 뭐해 나와! 함께여서 더 즐겁다. SingleTon Trip!</h1>
	</div>
<!-- First Photo Grid-->
	<div class="w3-row-padding w3-padding-16 w3-center" id="food">
		<h3 class="text-left">숙소</h3>
		<div class="w3-row-padding w3-padding-16">

		<div class="w3-third w3-margin-bottom">
			<img src="images/room_single.jpg" alt="Norway" style="width:100%">
				<div class="w3-container w3-white">
					<h3>Single Room</h3>
					<h6 class="w3-opacity">From $99</h6>
					<p>Single bed</p>
					<p>15m<sup>2</sup></p>
					<p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i></p>
					<button class="w3-btn-block w3-margin-bottom">Choose Room</button>
				</div>
			</div>

			<div class="w3-third w3-margin-bottom">
				<img src="images/room_double.jpg" alt="Norway" style="width:100%">
				<div class="w3-container w3-white">
					<h3>Double Room</h3>
					<h6 class="w3-opacity">From $149</h6>
					<p>Queen-size bed</p>
					<p>25m<sup>2</sup></p>
					<p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i></p>
					<button class="w3-btn-block w3-margin-bottom">Choose Room</button>
				</div>
			</div>

			<div class="w3-third w3-margin-bottom">
				<img src="images/room_deluxe.jpg" alt="Norway" style="width:100%">
				<div class="w3-container w3-white">
					<h3>Deluxe Room</h3>
					<h6 class="w3-opacity">From $199</h6>
					<p>King-size bed</p>
					<p>40m<sup>2</sup></p>
					<p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i> <i class="fa fa-glass"></i> <i class="fa fa-cutlery"></i></p>
					<button class="w3-btn-block w3-margin-bottom">Choose Room</button>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:10px">

<!-- First Photo Grid-->
<div class="w3-row-padding w3-padding-16 w3-center" id="food">
	<h3 class="text-left">인기트립</h3>
	<div class="w3-quarter">
		<a href=""><img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcT4ITem_mFudft8G_OT8TH5J8juxcfAlRMTEJbD4mxzBOUxDd5SgQ" alt="Sandwich" style="width:100%"></a>
	</div>
	<div class="w3-quarter">
		<a href=""><img src="http://cfd.tourtips.com/@ext/2015030949/gjek6w/10-400x600.jpg" alt="Steak" style="width:100%"></a>
	</div>
	<div class="w3-quarter">
		<a href=""><img src="http://anzfhs.org.au/wp-content/uploads/2015/04/Victoria-400x600.jpg" alt="Cherries" style="width:100%"></a>
	</div>
	<div class="w3-quarter">
		<a href=""><img src="http://4389bn3wyeoif3tav40ku9a1.wpengine.netdna-cdn.com/wp-content/uploads/2017/01/Alicia-Conrad-400x600.jpg" alt="Pasta and Wine" style="width:100%"></a>
	</div>
</div>

<!-- Second Photo Grid-->
<div class="w3-row-padding w3-padding-16 w3-center">
	<h3 class="text-left">트립</h3>
	<div class="w3-quarter">
		<a href=""><img src="https://www.lds.org/youth/bc/youth/content/images/5-Ways-to-Use-Family-Photos-400x600-1521179.jpg" alt="Popsicle" style="width:100%"></a>
	</div>
	<div class="w3-quarter">
		<a href=""><img src="http://www.blackstarfarms.com/wp-content/uploads/2015/06/Cole-Thornton-headshot-400x600.jpg" alt="Salmon" style="width:100%"></a>
	</div>
	<div class="w3-quarter">
		<a href=""><img src="http://image14.hanatour.com/uploads/2011/11/542-400x600.jpg" alt="Sandwich" style="width:100%"></a>
	</div>
	<div class="w3-quarter">
		<a href=""><img src="http://lobolife.unm.edu/wp-content/uploads/2017/01/3V8A5399-400x600.jpg" alt="Croissant" style="width:100%"></a>
	</div>
</div>

<hr id="about">

<!-- About Section -->
<div class="w3-container w3-padding-32 w3-center">
	<h3>이달의 회원</h3><br>
	<a href=""><img src="images/chef.jpg" alt="Me" class="w3-image" style="display:block;margin:auto" width="800" height="533"></a>
	<div class="w3-padding-32">
		<h3><b>요리교실</b></h3>
		<h6><i>즐거운 요리교실</i></h6>
		<p>평소에 요리에 관심이 많았는데 이번 기회를 통해서 이태리요리를 배우고 체험할 수 있어서 정말 즐거웠습니다. 다음에 또 기회가 된다면 참여하고싶네요.</p>
	</div>
</div>
</div>
<c:import url="./module/footer.jsp"></c:import>