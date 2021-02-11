function CheckAddProduct(){
	
	const productId = document.querySelector("#productId");
	const pname = document.querySelector("#pname");
	const unitprice = document.querySelector("#unitprice");
	const unitsInstock = document.querySelector("#unitsInstock");
	
	
	//상품 아이디 체크
	if(!check(/^P[0-9]{4,11}$/,productId,"[상품코드]\nP와 숫자를 조합하여 5~12자까지 입력하세요.\n첫 글자는 반드시 P로 시작하세요")){
		return false;
	}
	
	//상품명
	
	if(pname.value.length <4 || pname.value.length > 12){
		alert('[상품명]\n최소 4자에서 최대 12자까지 입력하세요.');
		pname.select();
		name.focus();
		return false;
	}
	
	//상품 가격 체큰
	if(unitprice.value.length == 0 || isNaN(unitprice.value)){
		alert('[가격]\n숫자만 입력하세요.');
		unitprice.select();
		unitprice.focus();
		return false;
	}
	
	if(unitprice.value < 0){
		alert('[가격]\n음수를 입력할 수 없습니다.');
		unitprice.select();
		unitprice.focus();
		return false;
	}else if(!check(/^\d+(?:[.]?[\d]?[\d])?$/,unitprice,"[가격]\n소수점 둘째 자리까지만 입력하세요.")){
		return false;
	}
	
	//재고 수 체크
	
	if(isNaN(unitsInstock.value)){
		alert('[재고수]\n숫자만 입력하세요.');
		unitsInstock.select();
		unitsInstock.focus();
		return false;
	}
	
	function check(regExp,e,msg){
		if(regExp.test(e.value)){
			return true;
		}
		alert(msg);
		e.select();
		e.focus();
		return false;
	}
	
	document.newProduct.submit();

}
