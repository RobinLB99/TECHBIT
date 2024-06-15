let formsasign = document.getElementsByName("asignarticketform");
const asignarbtn = document.getElementById("btnasign");

formsasign.forEach(form => {
   form.addEventListener("submit", (event) => {
      event.preventDefault();
      
      asignarbtn.addEventListener("click", () => {
            form.submit(); 
      });
   });
});