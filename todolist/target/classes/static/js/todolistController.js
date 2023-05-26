

const addAPI = 'http://localhost:8080/todolist/add';
const displayAPI = 'http://localhost:8080/todolist/all';

let todolistController = [];

function displayTodolist()
{
      //fetch data from database using the REST API endpoint from Spring Boot
      fetch(displayAPI)
          .then((resp) => resp.json())
          .then(function(data) {
              console.log("2. receive data")
              console.log(data);


              data.forEach(function (todolist) {
                  const todolistObj = {
                      title: todolist.title,
                      description: todolist.description,
                      targetDate: todolist.date

                 };



                  todolistController.push(todolistObj);
            });


            renderToDoListPage();
          })
          .catch(function(error) {
              console.log(error);
          });
}
function renderToDoListPage() {


   let display = "";


   for (let i = 0; i < todolistController.length; i++ ) {



       display += `
           <div  class="col-lg-4">
           <div class="card" style="width: 18rem;">
               <div class="card-body">
                   <p class="card-text">${todolistController[i].title}</p>
                   <p class="card-text">${todolistController[i].description}</p>
                   <p class="card-text">${todolistController[i].targetDate}</p>

               </div>
           </div>
       </div>
       `
   }


   document.querySelector("#row").innerHTML= display;


}





function addToDoList(title, description, targetDate)
{

   const formData = new FormData();
   formData.append('title', title);
   formData.append('description', description);
   formData.append('targetDate', targetDate);

    fetch(addAPI, {
        method :'POST',
        body : formData
    })
    .then((response)=>{
            console.log(response.status); // Will show you the status - 200 ok, 500, 404
            if (response.ok) {
                alert("Successfully Added To Do List!")

            }
            else {
               alert("Something went wrong. Please try again")
            }
    })
    .catch((error)=>{

        console.log("error:" + error);
        alert("Error adding to the list");

    })

};


