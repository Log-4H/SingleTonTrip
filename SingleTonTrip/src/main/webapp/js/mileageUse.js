function btnClick() {
    //대입 숫자
    var num1=document.getElementById("total").value;
    var num2=document.getElementById("mileage").value;
    //연산자
    var operation=document.getElementById("operation").value;
    //결과값 넣기
    document.getElementById("price").innerHTML =eval(num1+operation+num2); 
}