document.getElementById("formEditUser").addEventListener("submit", editPost)

function editPost(e) {
    e.preventDefault();

    let id = document.getElementById("idEdit").value;
    let name = document.getElementById("nameEdit").value;
    let lastname = document.getElementById("lastnameEdit").value;
    let age = document.getElementById("ageEdit").value;
    let login = document.getElementById("loginEdit").value;
    let password = document.getElementById("passwordEdit").value;
    // let passwordOld = document.getElementById("passwordEdit").value;
    let roles = setRoles(Array.from(document.getElementById("roleEdit").selectedOptions)
        .map(option => option.value));

    // if (password === null || password === '') {
    //     password = getUser().${user.password}
    // }

    fetch("http://localhost:8088/api/users", {
        method:"PUT",
        headers: {
            "Accept": "application/json, text/plain, */*",
            "Content-type":"application/json"
        },
        body:JSON.stringify({
            id:id,
            name:name,
            lastname:lastname,
            age:age,
            login:login,
            password:password,
            roles:roles
        })
    }).finally(() => {
        $('#modalEDIT').modal("hide")
        getUsers();
    })
}