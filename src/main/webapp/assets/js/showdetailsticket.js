var listdetails = document.getElementsByName("detail");
var titlet = document.getElementById("title");
var categoryt = document.getElementById("categoryt")
var creationt = document.getElementById("creacion");
var autort = document.getElementById("autor");
var detallest = document.getElementById("detallest");

listdetails.forEach(element => {
    element.addEventListener("click", function () {
       titlet.innerText = element.children[1].value;
       categoryt.innerText = element.children[2].value;
       creationt.innerText = element.children[3].value;
       autort.innerText = element.children[4].value;
       detallest.innerHTML = element.children[5].value;
    });
});


