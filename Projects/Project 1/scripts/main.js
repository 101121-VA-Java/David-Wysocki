// retrieving token from session storage if it exists
let token = sessionStorage.getItem("token");

// if no token is present, redirect to the login page
if (!token) {
  window.location.href = "views/login.html";
}

// if()

// targets logout button
document.getElementById("logout-button").addEventListener("click", logout);
// document
//   .getElementById("reimbursements")
//   .addEventListener("click", getAllReimbursements);

function logout() {
  sessionStorage.clear();
  window.location.href = "login.html";
}
function getAllReimbursements() {
  console.log("Hello World");
  fetch(`http://localhost:8080/reimbursement`, {
    method: "GET",
    headers: {
      Authorization: token,
    },
  }).then((res) =>
    res
      .json()
      .then((res) => {
        console.log(res);
        let result = "";
        for (let index = 0; index < res.length; index++) {
          result += `<div>Description: ${res[index].description}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += res[index].resolverId;
          result += res[index].resolved;
          result += res[index].authorId;
          result += res[index].submitted;
          result += res[index].id;
          result += res[index].type;
        }
        document.getElementById("testman").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
  // console.log(response);
}
