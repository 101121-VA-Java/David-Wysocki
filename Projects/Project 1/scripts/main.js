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
          let date1 = new Date(res[index].submitted);
          let fulldate =
            date1.getMonth() +
            1 +
            "/" +
            date1.getDay() +
            "/" +
            date1.getFullYear() +
            " " +
            date1.getHours() +
            ":" +
            date1.getMinutes();
          let date2 = new Date(res[index].resolved);
          let fulldate2 =
            date2.getMonth() +
            1 +
            "/" +
            date2.getDay() +
            "/" +
            date2.getFullYear() +
            " " +
            date2.getHours() +
            ":" +
            date2.getMinutes();
          result += `
            <div>
              <b>Request</b>
            </div>
          `;
          result += `<br><div>Description: ${res[index].description}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += `<div>Resolved By: ${res[index].resolverId}</div>`;
          result += `<div>Resolved At: ${fulldate2}</div>`;
          result += `<div>Submitted By: ${res[index].authorId}</div>`;
          result += `<div>Submitted On: ${fulldate}</div>`;
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Reimbursement Type: ${res[index].type}</div>`;
          result += `<br><div>
            <button
              type="button"
              class="btn btn-success"
              onclick="changeReimbursement(${res[index].id}, 2)"
            >
              Approve
            </button>
            
          </div><br>`;
          result += `<div><button type="button" class="btn btn-danger" onclick="changeReimbursement(${res[index].id}, 3)">Deny</button></div><br>`;
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
          let date1 = new Date(res[index].submitted);
          let fulldate =
            date1.getMonth() +
            1 +
            "/" +
            date1.getDay() +
            "/" +
            date1.getFullYear() +
            " " +
            date1.getHours() +
            ":" +
            date1.getMinutes();
          let date2 = new Date(res[index].resolved);
          let fulldate2 =
            date2.getMonth() +
            1 +
            "/" +
            date2.getDay() +
            "/" +
            date2.getFullYear() +
            " " +
            date2.getHours() +
            ":" +
            date2.getMinutes();
          result += `<br><div>User ID: ${res[index].authorId}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += `<div>Description: ${res[index].description}</div>`;
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Reimbursement Type: ${res[index].type}</div>`;
          result += `<div>Submitted By: ${res[index].authorId}</div>`;
          result += `<div>Submitted On: ${fulldate}</div>`;
          result += `<div>Resolved By: ${res[index].resolverId}</div>`;
          result += `<div>Resolved At: ${fulldate2}</div>`;
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
          let date1 = new Date(res[index].submitted);
          let fulldate =
            date1.getMonth() +
            1 +
            "/" +
            date1.getDay() +
            "/" +
            date1.getFullYear() +
            " " +
            date1.getHours() +
            ":" +
            date1.getMinutes();
          let date2 = new Date(res[index].resolved);
          let fulldate2 =
            date2.getMonth() +
            1 +
            "/" +
            date2.getDay() +
            "/" +
            date2.getFullYear() +
            " " +
            date2.getHours() +
            ":" +
            date2.getMinutes();
          result += `<br><div>Description: ${res[index].description}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += `<div>Resolved By: ${res[index].resolverId}</div>`;
          result += `<div>Resolved At: ${fulldate2}</div>`;
          result += `<div>Submitted By: ${res[index].authorId}</div>`;
          result += `<div>Submitted On: ${fulldate}</div>`;
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Reimbursement Type: ${res[index].type}</div>`;
        }
        document.getElementById("manbox").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
}
function addRWindow() {
  document.getElementById(
    "empbox"
  ).innerHTML = `<main class="container-fluid mx-auto " style="padding: 0 7.5em;">
  <div class="container align-content-center" id="AddReimbursement">
      <br>
      <br>
      <br>
      <br>
      <form>
          <div id="bottomBorder" class="form-row justify-content-center">
              <h1 class="display-4">Add Reimbursement</h1>
          </div>
          <hr>
          <br>
          <div class="form-row justify-content-center">
              <label>Amount:</label>
          </div>
          <div class="form-row justify-content-center">
              <input class="inputstyle" type="text" name="amount" id="amount">
          </div>
          <br>
          <div class="form-row justify-content-center">
              <label>Description</label>
          </div>
          <div class="form-row justify-content-center">
              <input class="inputstyle" type="text" name="description" id="description">
          </div>
          <br>
          <div class="form-row justify-content-center"> Type </div>
          
          <div class="form-row justify-content-center">
              <label></label>
              <select class="form-select" aria-label="Default select example" id="type">
              <option selected>Open this select menu</option>
              <option value="1">Mileage</option>
              <option value="2">Lodging</option>
              <option value="3">Food</option>
              <option value ="4">Other</option>
            </select>
            </div>
          <br>
          <br>
          <br>
          <br>
          <div class="form-row justify-content-center">
              <input class="btn btn-outline-secondary" value="Submit Request" id="addsubmitButton" onclick='addReimbursement()'>
          </div>
          <br>
          <br>
          <div class="form-row justify-content-center">
              <div style="color:red;" id="error-div"></div>
          </div>`;
}
function viewPending(statusId) {
  console.log("In the function.");
  let seshId = sessionStorage.token.split(":")[0];
  fetch(`http://localhost:8080/user/${seshId}/status/${statusId}`, {
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
          let date1 = new Date(res[index].submitted);
          let fulldate =
            date1.getMonth() +
            1 +
            "/" +
            date1.getDay() +
            "/" +
            date1.getFullYear() +
            " " +
            date1.getHours() +
            ":" +
            date1.getMinutes();
          let date2 = new Date(res[index].resolved);
          let fulldate2 =
            date2.getMonth() +
            1 +
            "/" +
            date2.getDay() +
            "/" +
            date2.getFullYear() +
            " " +
            date2.getHours() +
            ":" +
            date2.getMinutes();
          result += `
            <div>
              <b>Pending Request</b>
            </div>
          `;
          result += `<br><div>Description: ${res[index].description}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += `<div>Resolved By: ${res[index].resolverId}</div>`;
          result += `<div>Resolved At: ${fulldate2}</div>`;
          result += `<div>Submitted On: ${fulldate}</div>`;
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Reimbursement Type: ${res[index].type}</div>`;
        }
        document.getElementById("empbox").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
}
function viewProfile() {
  console.log("In the function.");
  let seshId = sessionStorage.token.split(":")[0];
  fetch(`http://localhost:8080/user/${seshId}`, {
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
        // for (let index = 0; index < res.length; index++) {
        result += `<br><div>User ID: ${res.userid}</div>`;
        result += `<div>First Name: ${res.firstname}</div>`;
        result += `<div>Last Name: ${res.lastname}</div>`;
        result += `<div>Username: ${res.username}</div>`;
        result += `<div>Password: For your security, the password is not shared.</div>`;
        result += `<div>Email: ${res.email}</div>`;
        result += `<div>Role: ${res.role}</div>`;
        // }
        document.getElementById("empbox").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
}
function updateWindow() {
  document.getElementById(
    "empbox"
  ).innerHTML = `<main class="container-fluid mx-auto " style="padding: 0 7.5em;">
  <div class="container align-content-center" id="updateProfile">
      <br>
      <br>
      <br>
      <br>
      <form>
          <div id="bottomBorder" class="form-row justify-content-center">
              <h1 class="display-4">Update Profile Information</h1>
          </div>
          <hr>
          <br>
          <div class="form-row justify-content-center">
              <label>First Name</label>
          </div>
          <div class="form-row justify-content-center">
              <input class="inputstyle" type="text" name="firstname" id="firstname">
          </div>
          <br>
          <div class="form-row justify-content-center">
              <label>Last Name</label>
          </div>
          <div class="form-row justify-content-center">
              <input class="inputstyle" type="text" name="lastname" id="lastname">
          </div>
          <br>
          <div class="form-row justify-content-center">
              <label>User Name</label>
          </div>
          <div class="form-row justify-content-center">
              <input class="inputstyle" type="text" name="username" id="username">
          </div>
          <br>
          <div class="form-row justify-content-center">
              <label>Password</label>
          </div>
          <div class="form-row justify-content-center">
              <input class="inputstyle" type="text" name="password" id="password">
          </div>
          <br>
          <div class="form-row justify-content-center">
              <label>Email</label>
          </div>
          <div class="form-row justify-content-center">
              <input class="inputstyle" type="text" name="email" id="email">
          </div>
          <br>
          <br>
          <br>
          <br>
          <div class="form-row justify-content-center">
              <input class="btn btn-outline-secondary" value="Submit Updated Profile" id="submitUpdateProfile" onclick='updateEmployeeProfile(sessionStorage.token.split(":")[0])'>
          </div>
          <br>
          <br>
          <div class="form-row justify-content-center">
              <div style="color:red;" id="error-div"></div>
          </div>`;
}
function updateEmployeeProfile(userid) {
  let firstname = document.getElementById("firstname").value;
  let lastname = document.getElementById("lastname").value;
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;
  let email = document.getElementById("email").value;

  let xhr = new XMLHttpRequest();
  let payload = { userid, firstname, lastname, username, password, email };
  xhr.open("PUT", `${api}/user/${userid}`);

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
