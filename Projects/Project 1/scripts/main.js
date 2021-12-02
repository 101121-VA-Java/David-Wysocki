// retrieving token from session storage if it exists
let token = sessionStorage.getItem("token");
let api = "http://localhost:8080";
// if no token is present, redirect to the login page
if (!token) {
  window.location.href = "views/login.html";
}

// if()

// targets logout button

function inputForm() {
  // (document.getElementById("manbox").innerhtml = inputform())
  console.log(5);
  document.getElementById("manbox").innerHTML = `<form onsubmit="return false">
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Enter Employee ID</label>
      <input type="text" class="form-control" id="idInput" aria-describedby="emailHelp">
       
    </div>
    
    <button class="btn btn-primary" onclick="viewByEmp()">Submit</button>
    </form>`;
  console.log(7);
}
document.getElementById("logout-button").addEventListener("click", logout);
// document
//   .getElementById("reimbursements")
//   .addEventListener("click", getAllReimbursements);

function logout() {
  sessionStorage.clear();
  window.location.href = "login.html";
}
function getAllReimbursements() {
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
          result += `<br><div>Description: ${res[index].description}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += `<div>Resolved By: ${res[index].resolverId}</div>`;
          result += `<div>Resolved At: ${res[index].resolved}</div>`;
          result += `<div>Submitted By: ${res[index].authorId}</div>`;
          result += `<div>Submitted On: ${res[index].submitted}</div>`;
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Reimbursement Type: ${res[index].type}</div>`;
          result += `<div>
            <button
              type="button"
              class="btn btn-success"
              onclick="changeReimbursement(${res[index].id}, 2)"
            >
              Approve
            </button>
            
          </div>`;
          result += `<div><button type="button" class="btn btn-danger" onclick="changeReimbursement(${res[index].id}, 3)">Deny</button></div>`;
        }
        document.getElementById("manbox").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
}
function addReimbursement() {
  console.log("This works!");
  let amount = document.getElementById("amount").value;
  let description = document.getElementById("description").value;
  let authorId = sessionStorage.token.split(":")[0];
  let type = document.getElementById("type").value;
  let payload = { amount, description, authorId, type };
  let xhr = new XMLHttpRequest();
  xhr.open("POST", `${api}/reimbursement`);

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      console.log("success");
    } else if (xhr.readyState === 4) {
      console.log("Getting closer!");
    }
  };
  xhr.send(JSON.stringify(payload));
}

function changeReimbursement(reimbId, statusId) {
  console.log(reimbId);
  console.log(statusId);

  let xhr = new XMLHttpRequest();
  let payload = statusId;
  xhr.open("PUT", `${api}/reimbursement/${reimbId}`);

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      console.log("Hey! You're doing the thing!");
    } else if (xhr.readyState === 4) {
      console.log("You've got some work to do chibberoo");
    }
  };
  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.send(JSON.stringify(payload));
}
function getAllEmps() {
  fetch(`http://localhost:8080/user`, {
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
          result += `<br><div>User ID: ${res[index].userid}</div>`;
          result += `<div>First Name: ${res[index].firstname}</div>`;
          result += `<div>Last Name: ${res[index].lastname}</div>`;
          result += `<div>User Name: ${res[index].username}</div>`;
          result += `<div>Email: ${res[index].email}</div>`;
          result += `<div>Company Role: ${res[index].role}</div>`;
        }
        document.getElementById("manbox").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
}
function viewByEmp() {
  let id = document.getElementById("idInput").value;
  console.log(id);
  let api1 = "http://localhost:8080/reimbursement/author/" + id;
  fetch(`${api1}`, {
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
          result += `<br><div>User ID: ${res[index].authorId}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Reimbursement Type: ${res[index].type}</div>`;
          result += `<div>Submitted By: ${res[index].authorId}</div>`;
          result += `<div>Submitted On: ${res[index].submitted}</div>`;
          result += `<div>Resolved By: ${res[index].resolverId}</div>`;
          result += `<div>Resolved At: ${res[index].resolved}</div>`;
        }
        document.getElementById("manbox").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
}
function getByStatus(id) {
  console.log("In the function.");
  fetch(`http://localhost:8080/reimbursement/status/${id}`, {
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
          result += `<br><div>Description: ${res[index].description}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += `<div>Resolved By: ${res[index].resolverId}</div>`;
          result += `<div>Resolved At: ${res[index].resolved}</div>`;
          result += `<div>Submitted By: ${res[index].authorId}</div>`;
          result += `<div>Submitted On: ${res[index].submitted}</div>`;
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Reimbursement Type: ${res[index].type}</div>`;
        }
        document.getElementById("manbox").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
}
