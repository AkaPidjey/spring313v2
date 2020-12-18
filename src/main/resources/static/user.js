// (function () {
//     function refreshCurrentUserTable() {
//         $.get(`http://localhost:8080/api/users/getUser`)
//             .done((currentUser) => {
//                 $("#currentUserTableBody")
//                     .empty()
//                     .append($('<tr>')
//                         .append($('<td>').text(currentUser.id))
//                         .append($('<td>').text(currentUser.name))
//                         .append($('<td>').text(currentUser.lastname))
//                         .append($('<td>').text(currentUser.age))
//                         .append($('<td>').text(currentUser.login))
//                         .append($('<td>').text(currentUser.roles))
//                     );
//             })
//     }
//
//     refreshCurrentUserTable();
// })();