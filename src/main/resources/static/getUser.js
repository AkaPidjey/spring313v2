function getUser() {

    fetch("http://localhost:8088/getUser").then((res) => res.json())
        .then((user) => {
            let userRoles = "";
            for (let i = 0; i < user.roles.length; i++) {
                userRoles += `${user.roles[i].role} `
            }

            let output = "<tr>";
            output += `
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastname}</td>
                <td>${user.age}</td>
                <td>${user.login}</td>
                <td>${userRoles}</td>
            `;
            output += "<tr>";

            document.getElementById("getUserTable").innerHTML = output;
        })
}


//
// function getHeader() {
//     fetch(url).then((res) => res.json())
//         .then((user) => {
//             let userRoles = "";
//             for (let i = 0; i < user.roles.length; i++) {
//                 userRoles += `${user.roles[i].role} `
//             }
//             let output = "";
//             output += `${user.mail} with roles: ${userRoles}`;
//             document.getElementById("gHed").innerHTML = output;
//         })
// }
//
// getHeader()
getUser()