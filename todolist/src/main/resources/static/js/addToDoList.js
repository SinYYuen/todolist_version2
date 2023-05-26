

//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {


   // Prevent default action of the Form submission
   event.preventDefault();

   // Select the inputs
   const title = document.querySelector('#newItemTitleInput').value;
   const description = document.querySelector('#newItemDescriptionInput').value;
   const targetDate = document.querySelector('#newItemTargetDateInput').value;


   addToDoList(title, description, targetDate);//arguements


});

