// function getModalDelete(id) {
//     $.get("/api/admin/delete" + id, function (usr) {
//         $('#idDelete').val(id);
//         $('#nameDelete').val(usr.name);
//         $('#lastnameDelete').val(usr.lastname);
//         $('#ageDelete').val(usr.age);
//         $('#loginDelete').val(usr.login);
//         $('#passwordDelete').val(usr.password);
//     });
// }
//
//
//
//
//
//
//
// $('#formDeleteUser').click(function () {
//     let id = $('#idDelete').val();
//     $.ajax({
//         url: '/api/admin/delete/' + id,
//         type: 'DELETE',
//         dataType: 'text',
//     }).done(() => {
//         $('#modalDELETE').modal('hide')
//         getUsers();
//     });
// });