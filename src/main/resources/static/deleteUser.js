document.getElementById("formDeleteUser").addEventListener("submit", deletePost)

function deletePost(e){
    e.preventDefault();

    let id = document.getElementById("idDelete").value;
    let name = document.getElementById("nameDelete").value;
    let lastname = document.getElementById("lastnameDelete").value;
    let age = document.getElementById("ageDelete").value;
    let login = document.getElementById("loginDelete").value;
    let password = document.getElementById("passwordDelete").value;
    let roles = setRoles(Array.from(document.getElementById("roleDelete").selectedOptions)
        .map(option => option.value));

    fetch("http://localhost:8088/api/users", {
        method:"DELETE",
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
            roles:roles})
    }).finally(() => {
        $('#modalDELETE').modal("hide")
        getUsers();
    })
}