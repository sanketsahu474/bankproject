function check()
{
var letters = document.card.creditCard1.value.length +1;
if (letters <= 4)
{document.card.creditCard1.focus();}
else
{document.card.creditCard2.focus();}
}
function check2()
{
var letters2 = document.card.creditCard2.value.length +1;
if (letters2 <= 4)
{document.card.creditCard2.focus();}
else
{document.card.creditCard3.focus();}
}
function check3()
{
var letters2 = document.card.creditCard3.value.length +1;
if (letters2 <= 4)
{document.card.creditCard3.focus();}
else
{document.card.creditCard4.focus();}
}
function check4()
{
var letters2 = document.card.creditCard4.value.length +1;
if (letters2 <= 4)
{document.card.creditCard4.focus();}
else
{document.card.fromMonth.focus();}
}

function showInput()
{
document.getElementById("american").style.visibility='visible';
fname.innerHTML=document.getElementById("firstNameInput").value;
mname.innerHTML=document.getElementById("middleNameInput").value;
lname.innerHTML=document.getElementById("lastNameInput").value;
card1.innerHTML=document.getElementById("creditCard1").value;
card5.innerHTML=document.getElementById("creditCard1").value;
card2.innerHTML=document.getElementById("creditCard2").value;
card3.innerHTML=document.getElementById("creditCard3").value;
card4.innerHTML=document.getElementById("creditCard4").value;
card6.innerHTML=document.getElementById("creditCard4").value;
validFrom.innerHTML=document.getElementById("fromMonth").value;
expiry.innerHTML=document.getElementById("month").value;
cvv.innerHTML=document.getElementById("cvvInput").value;
}

function displayForm(c){ 
if(c.value === "1"){ 
document.getElementById("american").style.visibility='hidden';
document.getElementById('rcorners1').style.backgroundImage="url(images/ameri.png)";
document.getElementById('rcorners2').style.backgroundImage="url(images/creditcardback3.jpg)";
} 
else if(c.value ==="2"){ 
document.getElementById("american").style.visibility='hidden'; 
document.getElementById('rcorners1').style.backgroundImage="url(images/masters.png)";
document.getElementById('rcorners2').style.backgroundImage="url(images/back.png)";
document.getElementById('rcorners2').style.width="250";
document.getElementById('rcorners2').style.height="440";
} 
else if(c.value ==="3"){ 
document.getElementById("american").style.visibility='hidden'; 
document.getElementById('rcorners1').style.backgroundImage="url(images/visas.jpg)";
document.getElementById('rcorners2').style.backgroundImage="url(images/creditcardback3.jpg)";
}
else if(c.value ==="4"){ 
document.getElementById("american").style.visibility='hidden'; 
document.getElementById('rcorners1').style.backgroundImage="url(images/disc.jpg)";
document.getElementById('rcorners2').style.backgroundImage="url(images/creditcardback3.jpg)";
}
else{
}  
} 
