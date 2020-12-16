// $(document).ready(); {
//     getTableUser();
//     getTableAllUsers();
// }
//
// function getTableUser() {
//     fetch('http://localhost:8088/api/user').then(
//         response => {
//             response.json().then(
//                 data => {
//                     let rls = data.roles.length > 1 ? 'ROLE_ADMIN': 'ROLE_USER';
//                     let str = '<tr>' +
//                         '<td>' + data.id + '</td>' +
//                         '<td>' + data.name + '</td>' +
//                         '<td>' + data.lastname + '</td>' +
//                         '<td>' + data.age + '</td>' +
//                         '<td>' + data.login + '</td>' +
//                         '<td>' + rls + '</td>' +
//                         '</tr>';
//                     $('#tabUserPanel tbody').empty().append(str);
//                 });
//         });
// }
//
// function getTableAllUsers() {
//     fetch('http://localhost:8088/api/admin').then(
//         response => {
//             response.json().then(
//                 data => {
//                     let str = '';
//                     let rls = '';
//                     data.forEach(usr => {
//                         usr.roles.length > 1 ? rls = 'ROLE_ADMIN': rls = 'ROLE_USER';
//                         str += '<tr>' +
//                             '<td>' + usr.id + '</td>' +
//                             '<td>' + usr.name + '</td>' +
//                             '<td>' + usr.lastname + '</td>' +
//                             '<td>' + usr.age + '</td>' +
//                             '<td>' + usr.login + '</td>' +
//                             '<td>' + rls + '</td>' +
//                             '<td><button type="button" ' +
//                             'onclick="getModalEdit(' + usr.id + ')" ' +
//                             'class="btn btn-info" ' +
//                             'data-toggle="modal" ' +
//                             'data-target="#modalEDIT">Edit</button></td>' +
//                             '<td><button type="button" ' +
//                             'onclick="getModalDelete(' + usr.id + ')" ' +
//                             'class="btn btn-danger" ' +
//                             'data-toggle="modal" ' +
//                             'data-target="#modalDELETE">Delete</button></td>' +
//                             '</tr>';
//                     });
//                     $('#tabAllUsers tbody').empty().append(str);
//                 });
//         });
// }
//
// function getModalEdit(id) {
//     $.get("/api/admin" + id, function (usr) {
//         console.log(id)
//         $('#idEdit').val(usr.id)
//         $('#nameEdit').val(usr.name);
//         $('#lastname').val(usr.lastname);
//         $('#ageEdit').val(usr.age);
//         $('#loginEdit').val(usr.login);
//         $('#passwordEdit').val(usr.password);
//     });
// }
//
// function getModalDelete(id) {
//     $.get("/api/admin/" + id, function (usr) {
//         $('#idDelete').val(id);
//         $('#nameDelete').val(usr.name);
//         $('#lastnameDelete').val(usr.lastname);
//         $('#ageDelete').val(usr.age);
//         $('#loginDelete').val(usr.login);
//         $('#passwordDelete').val(usr.password);
//     });
// }
//
// $('#formNewUser').submit(function () {
//     $.post(
//         '/api/admin',
//         $('#formNewUser').serialize(),
//         function (newUser) {
//             document.location.href = newUser;
//         });
//     return false;
// });
//
// $('#formEditUser').submit(function () {
//     $.post(
//         '/api/admin',
//         $('#formEditUser').serialize(),
//         function (editUser) {
//             document.location.href = editUser;
//         });
//     return false;
// });
//
// $('#buttonDelete').click(function () {
//     let id = $('#idDelete').val();
//     $.ajax({
//         url: '/api/admin' + id,
//         type: 'DELETE',
//         dataType: 'text',
//     }).done(() => {
//         $('#modalDELETE').modal('hide')
//         getTableAllUsers();
//     });
// });