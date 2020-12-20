function getUsers() {
    fetch("http://localhost:8088/allUsers")
        .then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (user) {

                let userRoles = "";
                for (let i = 0; i < user.roles.length; i++){
                    userRoles+=`${user.roles[i].role} `
                }

                output += `
                <tr>
                <td id="id${user.id}">${user.id}</td>
                <td id="name${user.id}">${user.name}</td> 
                <td id="lastname${user.id}">${user.lastname}</td>
                <td id="age${user.id}">${user.age}</td>
                <td id="login${user.id}">${user.login}</td>
                <td id="password${user.id}">${user.password}</td>
                <td id="roles${user.id}">${userRoles}</td>
                <td>
                <a class="btn btn-info" 
                role="button"
                data-toggle="modal" 
                data-target="#edit" 
                id="callModalEdit"  
                onclick="openModalWindowEdit(${user.id})">Edit</a>
                </td>
                <td>
                <a class="btn btn-danger" 
                role="button"
                data-toggle="modal" 
                data-target="#delete" 
                id="delete-post"
                onclick="openModalWindowDelete(${user.id})">Delete</a>
                </td>
              </tr>
          `;
            });
            document.getElementById("getAllUsers").innerHTML = output;
        })
}
getUsers()